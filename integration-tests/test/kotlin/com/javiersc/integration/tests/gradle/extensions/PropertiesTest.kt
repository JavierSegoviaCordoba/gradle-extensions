package com.javiersc.integration.tests.gradle.extensions

import com.javiersc.gradle.testkit.test.extensions.GradleTestKitTest
import io.kotest.matchers.string.shouldContain
import kotlin.test.Test

internal class PropertiesTest : GradleTestKitTest() {

    @Test
    fun `1`() {
        gradleTestKitTest("gradle-extensions/properties/1") {
            withArguments("fakeFile")
            withEnvironment(
                mapOf(
                    "ENV_PROP_BOOLEAN" to "true",
                    "ENV_PROP_DOUBLE" to "3.5",
                    "ENV_PROP_INT" to "1",
                    "ENV_PROP_LONG" to "123456789012345",
                    "ENV_PROP_STRING" to "hello",
                )
            )

            // TODO: Add priority test for each property type (CLI, ENV, GRADLE LOCAL, LOCAL, and
            //  GRADLE PROPERTY)

            val output: String = build().output

            output.shouldContain("env.prop.boolean: true")
            output.shouldContain("env.prop.boolean2: null")
            output.shouldContain("ENV_PROP_BOOLEAN: true")
            output.shouldContain("ENV_PROP_BOOLEAN2: null")
            output.shouldContain("env.prop.double: 3.5")
            output.shouldContain("env.prop.double2: null")
            output.shouldContain("ENV_PROP_DOUBLE: 3.5")
            output.shouldContain("ENV_PROP_DOUBLE2: null")
            output.shouldContain("env.prop.int: 1")
            output.shouldContain("env.prop.int2: null")
            output.shouldContain("ENV_PROP_INT: 1")
            output.shouldContain("ENV_PROP_INT2: null")
            output.shouldContain("env.prop.long: 123456789012345")
            output.shouldContain("env.prop.long2: null")
            output.shouldContain("ENV_PROP_LONG: 123456789012345")
            output.shouldContain("ENV_PROP_LONG2: null")
            output.shouldContain("env.prop.string: hello")
            output.shouldContain("env.prop.string2: null")
            output.shouldContain("ENV_PROP_STRING: hello")
            output.shouldContain("ENV_PROP_STRING2: null")

            output.shouldContain("gradle.local.prop.boolean: true")
            output.shouldContain("gradle.local.prop.boolean2: null")
            output.shouldContain("gradle.local.prop.double: 3.5")
            output.shouldContain("gradle.local.prop.double2: null")
            output.shouldContain("gradle.local.prop.int: 1")
            output.shouldContain("gradle.local.prop.int2: null")
            output.shouldContain("gradle.local.prop.long: 123456789012345")
            output.shouldContain("gradle.local.prop.long2: null")
            output.shouldContain("gradle.local.prop.string: hello")
            output.shouldContain("gradle.local.prop.string2: null")

            output.shouldContain("local.prop.boolean: true")
            output.shouldContain("local.prop.boolean2: null")
            output.shouldContain("local.prop.double: 3.5")
            output.shouldContain("local.prop.double2: null")
            output.shouldContain("local.prop.int: 1")
            output.shouldContain("local.prop.int2: null")
            output.shouldContain("local.prop.long: 123456789012345")
            output.shouldContain("local.prop.long2: null")
            output.shouldContain("local.prop.string: hello")
            output.shouldContain("local.prop.string2: null")

            output.shouldContain("prop.boolean: true")
            output.shouldContain("prop.boolean2: null")
            output.shouldContain("prop.double: 3.5")
            output.shouldContain("prop.double2: null")
            output.shouldContain("prop.int: 1")
            output.shouldContain("prop.int2: null")
            output.shouldContain("prop.long: 123456789012345")
            output.shouldContain("prop.long2: null")
            output.shouldContain("prop.string: hello")
            output.shouldContain("prop.string2: null")
        }
    }

    @Test
    fun `priority`() {
        gradleTestKitTest("gradle-extensions/properties/1") {
            withArguments("fakeFile", "-Pcli.prop.priority=11")
            withEnvironment(mapOf("ENVIRONMENT_PROP_PRIORITY" to "22"))
            build()
                .output
                .shouldContain("cli.prop.priority: 11")
                .shouldContain("environment.prop.priority: 22")
                .shouldContain("gradle.local.prop.priority: 33")
                .shouldContain("local.prop.priority: 44")
                .shouldContain("prop.priority: 55")
        }
    }
}
