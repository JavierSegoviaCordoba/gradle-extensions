package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

internal class VersionCatalogsTest : GradleTest() {

    @Test
    fun `1`() {
        gradleTestKitTest("gradle-extensions/version-catalogs/1") {
            gradlew("fakeFile")
                .output
                .shouldContain("Library by module: io.kotest:kotest-assertions-core:5.0.1")
                .shouldContain("Null library by module: null")
                .shouldContain(
                    "Libraries by group: [io.kotest:kotest-assertions-core:5.0.1, io.kotest:kotest-property:5.0.1]"
                )
        }
    }
}
