package com.javiersc.integration.tests

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import com.javiersc.gradle.testkit.test.extensions.resourceFile
import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class GradleTestKitExtensionsTest : GradleTest() {

    @Test
    fun test() {
        gradleTestKitTest(sandboxPath = "fake-file") {
            andWithInfo()
            println(build().output)
        }
    }

    @Test
    fun `argument txt`() {
        val basePath = resourceFile("arguments-txt")
        val sandboxDirs = resourceFile("arguments-txt").listFiles()?.toList().orEmpty()
        for (sandboxDir in sandboxDirs) {
            val relativePath = sandboxDir.relativeTo(basePath.parentFile).path
            gradleTestKitTest(sandboxPath = relativePath) {
                withArgumentsFromTXT()
                val actualArguments = arguments.joinToString(" ")
                val expectArguments = projectDir.resolve("ARGUMENTS.expect.txt").readLines().first()
                actualArguments.shouldBe(expectArguments)
            }
        }
    }
}
