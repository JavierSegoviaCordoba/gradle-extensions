package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

class DelegatedPropertiesTest : GradleTest() {

    @Test
    fun `1`() {
        gradleTestKitTest("gradle-extensions/delegated/properties/1") {
            gradlew("fakeFile")
                .outputTrimmed
                .shouldContain(
                    """
                        |DELEGATED 1
                        |DELEGATED 2
                    """
                        .trimMargin()
                )
        }
    }
}
