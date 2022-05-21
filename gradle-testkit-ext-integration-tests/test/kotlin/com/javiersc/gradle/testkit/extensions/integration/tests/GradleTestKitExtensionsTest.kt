package com.javiersc.gradle.testkit.extensions.integration.tests

import com.javiersc.gradle.testkit.extensions.andWithInfo
import com.javiersc.gradle.testkit.extensions.gradleTestKitTest
import kotlin.test.Test

class GradleTestKitExtensionsTest {

    @Test
    fun test() =
        gradleTestKitTest(sandboxPath = "fake-file") {
            andWithInfo()
            println(build().output)
        }
}
