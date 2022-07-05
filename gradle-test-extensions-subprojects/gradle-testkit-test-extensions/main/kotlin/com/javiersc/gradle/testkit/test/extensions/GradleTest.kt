package com.javiersc.gradle.testkit.test.extensions

import com.javiersc.gradle.testkit.test.extensions._internal.argumentsTxt
import java.io.File
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.io.CleanupMode.ON_SUCCESS
import org.junit.jupiter.api.io.TempDir

public abstract class GradleTest {

    @TempDir(cleanup = ON_SUCCESS) private lateinit var tempDir: File

    @TempDir(cleanup = ON_SUCCESS) private lateinit var isolatedTempDir: File

    public fun gradleTestKitTest(
        sandboxPath: String? = null,
        name: String = sandboxPath?.sanitizedSandboxPathPrefix() ?: "",
        withDebug: Boolean = false,
        withPluginClasspath: Boolean = true,
        isolated: Boolean = false,
        test: GradleRunner.() -> Unit,
    ) {
        val projectDir = tempDir.resolve(name).apply(File::mkdirs)

        if (sandboxPath != null) resourceFile(sandboxPath).copyRecursively(projectDir)

        test(
            GradleRunner.create().apply {
                withDebug(withDebug)
                if (withPluginClasspath) withPluginClasspath()
                if (isolated) {
                    val isolatedDir = isolatedTempDir.resolve(name).apply(File::mkdirs)
                    withTestKitDir(isolatedDir)
                }
                withProjectDir(projectDir)
            },
        )
    }

    public fun GradleRunner.testBuildCache(
        resultingTask: String? = null,
        invalidate: (GradleRunner.() -> Unit)? = null,
    ) {
        val taskName =
            checkNotNull(resultingTask ?: arguments.firstOrNull()) {
                "There is not a task in the arguments to check if build cache works"
            }
        val task = ":$taskName"

        andWithBuildCache()
        build()

        invalidate?.invoke(this)
        cleanBuildDirectory()

        val result = build()

        val outcome =
            checkNotNull(result.task(task)) { "The outcome for the task $task is null" }.outcome

        val expectOutcome = if (invalidate == null) TaskOutcome.FROM_CACHE else TaskOutcome.SUCCESS

        check(outcome == expectOutcome) { "The outcome is $outcome and must be $expectOutcome" }
    }

    public fun GradleRunner.testConfigurationCache(
        expectTaskOutcome: TaskOutcome = TaskOutcome.UP_TO_DATE,
        resultingTask: String? = null,
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

    public fun GradleRunner.withArgumentsFromTXT() {
        withArguments(argumentsTxt)
    }

    public fun GradleRunner.gradlewArgumentFromTXT(vararg additionalArgs: String): BuildResult =
        gradlew(*argumentsTxt.toTypedArray() + additionalArgs)

    public fun GradleRunner.gradlew(vararg arguments: String): BuildResult {
        val previousArgs: List<String> = this.arguments.toList()
        val result: BuildResult = withArguments(*arguments).build()
        withArguments(previousArgs)
        return result
    }

    public fun GradleRunner.clean(): BuildResult {
        val previousArgs: List<String> = arguments.toList()
        val result: BuildResult = withArguments("clean").build()
        withArguments(previousArgs)
        return result
    }

    public fun GradleRunner.cleanBuildDirectory() {
        for (file in projectDir.walkTopDown()) {
            if (file.isDirectory && file.name == "build") file.deleteRecursively()
        }
    }

    public fun projectProperty(value: String): String = "-P$value"

    public fun GradleRunner.andWithProjectProperty(value: String) {
        withArguments(arguments + projectProperty(value))
    }

    public fun systemProperty(value: String): String = "-D$value"

    public fun GradleRunner.andWithSystemProperty(value: String) {
        withArguments(arguments + systemProperty(value))
    }

    public fun info(): String = "--info"

    public fun GradleRunner.andWithInfo() {
        withArguments(arguments + info())
    }

    public fun stacktrace(): String = "--stacktrace"

    public fun GradleRunner.andWithStacktrace() {
        withArguments(arguments + stacktrace())
    }

    public fun scan(): String = "--scan"

    public fun GradleRunner.andWithScan() {
        withArguments(arguments + scan())
    }

    public fun buildCache(): String = "--build-cache"

    public fun GradleRunner.andWithBuildCache() {
        withArguments(arguments + buildCache())
    }

    public fun noBuildCache(): String = "--no-build-cache"

    public fun GradleRunner.andWithNoBuildCache() {
        withArguments(arguments + noBuildCache())
    }

    public fun configurationCache(): String = "--configuration-cache"

    public fun GradleRunner.andWithConfigurationCache() {
        withArguments(arguments + configurationCache())
    }

    public fun noConfigurationCache(): String = "--no-configuration-cache"

    public fun GradleRunner.andWithNoConfigurationCache() {
        withArguments(arguments + noConfigurationCache())
    }

    public fun configurationCacheProblemsWarn(): String = "--configuration-cache-problems=warn"

    public fun GradleRunner.andWithConfigurationCacheProblemsWarn() {
        withArguments(arguments + configurationCacheProblemsWarn())
    }

    public val BuildResult.outputTrimmed: String
        get() = output.lines().joinToString("\n", transform = String::trim)
}

private fun String.sanitizedSandboxPathPrefix(): String = replace("/", "--").replace("\\", "--")
