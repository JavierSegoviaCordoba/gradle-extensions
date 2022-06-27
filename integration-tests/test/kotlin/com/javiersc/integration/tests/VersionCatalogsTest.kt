package com.javiersc.integration.tests

import com.javiersc.gradle.testkit.extensions.gradleTestKitTest
import com.javiersc.gradle.testkit.extensions.gradlew
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

internal class VersionCatalogsTest {

    @Test
    fun `1`() {
        gradleTestKitTest("version-catalogs/1") {
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
