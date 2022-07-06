package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

internal class PropertiesTest : GradleTest() {

    @Test
    fun `1`() {
        gradleTestKitTest("gradle-extensions/properties/1") {
            gradlew("fakeFile")
                .output
                .shouldContain("prop.boolean: true")
                .shouldContain("prop.boolean2: false")
                .shouldContain("local.prop.boolean: true")
                .shouldContain("local.prop.boolean2: false")
                .shouldContain("prop.double: 3.5")
                .shouldContain("prop.double2: null")
                .shouldContain("local.prop.double: 3.5")
                .shouldContain("local.prop.double2: null")
                .shouldContain("prop.int: 1")
                .shouldContain("prop.int2: null")
                .shouldContain("local.prop.int: 1")
                .shouldContain("local.prop.int2: null")
                .shouldContain("prop.long: 123456789012345")
                .shouldContain("prop.long2: null")
                .shouldContain("local.prop.long: 123456789012345")
                .shouldContain("local.prop.long2: null")
                .shouldContain("prop.string: hello")
                .shouldContain("prop.string2: null")
                .shouldContain("local.prop.string: hello")
                .shouldContain("local.prop.string2: null")
        }
    }

    @Test
    fun `failed-1`() {
        gradleTestKitTest("gradle-extensions/properties/failed-1") {
            withArguments("fakeFile")
            buildAndFail()
                .output
                .shouldContain(
                    "The property `prop.double` is not available in any of the next sources:"
                )
        }
    }
}
