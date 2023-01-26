package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTestKitTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

internal class ProjectTest : GradleTestKitTest() {

    @Test
    fun `1`() {
        gradleTestKitTest("gradle-extensions/project/1") {
            gradlew("fakeFile")
                .output
                .shouldContain("root - isRootProject: true")
                .shouldContain("root - module: com.javiersc.fake:gradle-project-extensions")
                .shouldContain("root - library: com.javiersc.fake:gradle-project-extensions:1.0.0")
                .shouldContain("root(1.0.0) - isSnapshot: false")
                .shouldContain("root(1.0.0) - isSnapshot: true")
                .shouldContain("root(1.0.0-SNAPSHOT) - isSnapshot: true")
                .shouldContain("root(1.0.0-SNAPSHOT) - isSnapshot: false")
                .shouldContain("library - isRootProject: false")
        }
    }
}
