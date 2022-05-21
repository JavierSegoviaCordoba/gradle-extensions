package com.javiersc.gradle.testkit.extensions.integration.tests

import com.javiersc.gradle.extensions.lifecycleColored
import com.javiersc.kotlin.stdlib.AnsiColor
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class FakePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register("fakeFile") { fakeFile ->
            target.logger.lifecycleColored(AnsiColor.Foreground.White) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.BrightGreen) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.Yellow) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.BrightYellow) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.Blue) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.Red) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.Cyan) { "Fake File" }
            target.logger.lifecycleColored(AnsiColor.Foreground.Purple) { "Fake File" }
        }
    }
}
