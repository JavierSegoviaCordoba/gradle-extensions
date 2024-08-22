package com.javiersc.gradle.testkit.test.extensions

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.io.CleanupMode.ON_SUCCESS
import org.junit.jupiter.api.io.TempDir

public open class GradleTestKitTest : GradleTestKitTestApi {

    @TempDir(cleanup = ON_SUCCESS) private lateinit var projectDir: File

    @TempDir(cleanup = ON_SUCCESS) private lateinit var isolatedDir: File

    override fun gradleTestKitTest(
        sandboxPath: String?,
        name: String,
        debug: Boolean,
        pluginClasspath: Boolean,
        isolated: Boolean,
        test: TestKitTest,
    ) {
        val projectDir = projectDir.resolve(name).apply(File::mkdirs)

        if (sandboxPath != null) resourceFile(sandboxPath).copyRecursively(projectDir)

        val runner =
            GradleRunner.create().apply {
                withDebug(debug)
                if (pluginClasspath) withPluginClasspath()
                if (isolated) {
                    val isolatedDir = isolatedDir.resolve(name).apply(File::mkdirs)
                    withTestKitDir(isolatedDir)
                }
                withProjectDir(projectDir)
            }

        test.run { runner.execute() }
    }

    override fun GradleRunner.testBuildCache(resultingTask: String?, invalidate: TestKitTest?) {
        val taskName =
            checkNotNull(resultingTask ?: arguments.firstOrNull()) {
                "There is not a task in the arguments to check if build cache works"
            }
        val task = ":$taskName"

        andWithBuildCache()
        build()

        invalidate?.run { execute() }
        cleanBuildDirectory()

        val result = build()

        val outcome =
            checkNotNull(result.task(task)) { "The outcome for the task $task is null" }.outcome

        val expectOutcome = if (invalidate == null) TaskOutcome.FROM_CACHE else TaskOutcome.SUCCESS

        check(outcome == expectOutcome) { "The outcome is $outcome and must be $expectOutcome" }
    }

    override fun GradleRunner.testConfigurationCache(
        expectTaskOutcome: TaskOutcome,
        resultingTask: String?,
    ) {
        val taskName =
            checkNotNull(resultingTask ?: arguments.firstOrNull()) {
                "There is not a task in the arguments to check if configuration cache works"
            }
        val task = ":$taskName"

        andWithConfigurationCache()
        andWithNoBuildCache()
        build()

        val result = build()

        check(result.output.contains("Reusing configuration cache")) {
            "Configuration cache is not working"
        }

        val outcome =
            checkNotNull(result.task(task)) { "The outcome for the task $task is null" }.outcome

        check(outcome == expectTaskOutcome) {
            "The outcome is $outcome and must be $expectTaskOutcome"
        }
    }
}

public fun interface TestKitTest {
    public fun GradleRunner.execute()
}
