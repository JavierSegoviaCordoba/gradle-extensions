package com.javiersc.integration.tests

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class GradleTestExtensionsTest : GradleTest() {

    @Test
    fun `GIVEN a null sandbox path WHEN project builds THEN project's name is an empty string`() {
        gradleTest(sandboxPath = null) { name.shouldBe("") }
    }

    @Test
    fun `GIVEN a sandbox path WHEN project builds THEN project's name is 'fake-file'`() {
        gradleTest(sandboxPath = "fake-file") { name.shouldBe("fake-file") }
    }
}
