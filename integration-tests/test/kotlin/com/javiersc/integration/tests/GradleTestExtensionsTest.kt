package com.javiersc.integration.tests

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class GradleTestExtensionsTest : GradleTest() {

    @Test
    fun `given a sandbox path when project builds then project's name is fake-file`() {
        gradleTest(sandboxPath = "fake-file") { name.shouldBe("fake-file") }
    }
}
