package com.javiersc.gradle.testkit.extensions

import java.io.File
import java.nio.file.Files.createTempDirectory
import java.nio.file.Path
import java.nio.file.Paths
import org.gradle.testkit.runner.GradleRunner

internal val sandboxPath: Path = Paths.get("build/sandbox").apply { toFile().mkdirs() }

internal val sandboxIsolatedPath: Path =
    Paths.get("build/sandbox-isolated").apply { toFile().mkdirs() }

internal fun String.copyResourceTo(destination: File) {
    getResource(this).copyRecursively(destination)
}

internal fun createSandboxDirectory(prefix: String): File =
    createTempDirectory(sandboxPath, if (prefix.isBlank()) prefix else "$prefix-").toFile()

internal fun createSandboxIsolatedDirectory(prefix: String): File =
    createTempDirectory(sandboxIsolatedPath, if (prefix.isBlank()) prefix else "$prefix-").toFile()

internal val GradleRunner.argumentsTxt: List<String>
    get() {
        val argumentsFile = File("$projectDir/ARGUMENTS.txt")
        return if (argumentsFile.exists()) argumentsFile.readLines().first().split(" ")
        else emptyList()
    }

private fun getResource(resource: String): File =
    File(Thread.currentThread().contextClassLoader?.getResource(resource)?.toURI()!!)
