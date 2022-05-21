package com.javiersc.gradle.testkit.extensions.integration.tests

import com.javiersc.gradle.testkit.extensions.gradleTestKitTest
import com.javiersc.gradle.testkit.extensions.withInfo
import kotlin.test.Test

class GradleTestKitExtensionsTest {

    @Test
    fun test() =
        gradleTestKitTest(sandboxPath = "fake-file") {
            withInfo()
            println(build().output)
        }
}
