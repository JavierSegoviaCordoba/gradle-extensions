package com.javiersc.integration.tests

import com.javiersc.gradle.project.test.extensions.GradleProjectTest
import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class GradleProjectTestExtensionsTest : GradleProjectTest() {

    @Test
    fun `GIVEN a null sandbox path WHEN project builds THEN project's name is an empty string`() {
        gradleProjectTest(sandboxPath = null) { name.shouldBe("") }
    }

    @Test
    fun `GIVEN a sandbox path WHEN project builds THEN project's name is 'fake-file'`() {
        gradleProjectTest(sandboxPath = "fake-file") { name.shouldBe("fake-file") }
    }
}
