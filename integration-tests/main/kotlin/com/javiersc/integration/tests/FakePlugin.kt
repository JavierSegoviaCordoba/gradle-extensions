package com.javiersc.integration.tests

import org.gradle.api.Plugin
import org.gradle.api.Project

internal abstract class FakePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register("fakeFile") { target.logger.lifecycle("Fake File") }
    }
}
