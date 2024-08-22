package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTestKitTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

class DelegatedPropertiesTest : GradleTestKitTest() {

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
