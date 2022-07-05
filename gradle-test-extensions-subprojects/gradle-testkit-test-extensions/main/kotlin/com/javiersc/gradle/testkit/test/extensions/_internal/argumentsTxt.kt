package com.javiersc.gradle.testkit.test.extensions._internal

import org.gradle.testkit.runner.GradleRunner

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
