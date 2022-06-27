@file:OptIn(ExperimentalStdlibApi::class)

package com.javiersc.gradle.testkit.test.extensions

import java.io.File
import java.nio.file.Files.createTempDirectory
import java.nio.file.Path
import java.nio.file.Paths
import org.gradle.testkit.runner.GradleRunner

public fun resourceFile(resource: String): File =
    File(Thread.currentThread().contextClassLoader?.getResource(resource)?.toURI()!!)

internal val sandboxPath: Path = Paths.get("build/sandbox").apply { toFile().mkdirs() }

internal val sandboxIsolatedPath: Path =
    Paths.get("build/sandbox-isolated").apply { toFile().mkdirs() }

internal fun String.copyResourceTo(destination: File) {
    resourceFile(this).copyRecursively(destination)
}

internal fun createSandboxDirectory(prefix: String): File =
    createTempDirectory(sandboxPath, if (prefix.isBlank()) prefix else "$prefix-").toFile()

internal fun createSandboxIsolatedDirectory(prefix: String): File =
    createTempDirectory(sandboxIsolatedPath, if (prefix.isBlank()) prefix else "$prefix-").toFile()

internal val GradleRunner.argumentsTxt: List<String>
    get() {
        val argumentsFile = projectDir.resolve("ARGUMENTS.txt")
        return if (argumentsFile.exists()) {
            buildList {
                val line = argumentsFile.readLines().first()
                var (nextArgument, remaining) = line.nextArgument()
                nextArgument?.let(::add)
                while (nextArgument != null || remaining != null) {
                    val (nextArgumentWhile, remainingWhile) =
                        remaining?.nextArgument() ?: (null to null)
                    nextArgument = nextArgumentWhile
                    remaining = remainingWhile
                    nextArgument?.let(::add)
                }
            }
        } else {
            emptyList()
        }
    }

private fun String.nextArgument(): Pair<String?, String?> {
    val line = dropWhile(Char::isWhitespace)
    val (nextArgument, remaining) =
        when {
            line.isBlank() -> null to null
            line.startsWith("\"") -> {
                val nextArgument = line.drop(1).takeWhile { it != '"' }
                val remaining = line.drop(1 + nextArgument.length + 1)
                nextArgument to remaining
            }
            else -> {
                val nextArgument = line.takeWhile { !it.isWhitespace() }
                val remaining = line.drop(nextArgument.length)
                nextArgument to remaining
            }
        }
    return nextArgument to remaining
}
