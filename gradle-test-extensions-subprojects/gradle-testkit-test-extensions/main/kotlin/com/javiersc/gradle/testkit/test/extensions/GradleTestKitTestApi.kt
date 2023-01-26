package com.javiersc.gradle.testkit.test.extensions

import com.javiersc.gradle.common.test.extensions.GradleCommonTestApi
import com.javiersc.gradle.testkit.test.extensions._internal.argumentsTxt
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome

public interface GradleTestKitTestApi : GradleCommonTestApi {

    public fun gradleTestKitTest(
        sandboxPath: String? = null,
        name: String = buildValidPathName(sandboxPath),
        debug: Boolean = false,
        pluginClasspath: Boolean = true,
        isolated: Boolean = false,
        test: TestKitTest,
    )

    public fun GradleRunner.testBuildCache(
        resultingTask: String? = null,
        invalidate: TestKitTest? = null,
    )

    public fun GradleRunner.testConfigurationCache(
        expectTaskOutcome: TaskOutcome = TaskOutcome.UP_TO_DATE,
        resultingTask: String? = null,
    )

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

    public fun GradleRunner.andWithProjectProperty(value: String) {
        withArguments(arguments + projectProperty(value))
    }

    public fun GradleRunner.andWithSystemProperty(value: String) {
        withArguments(arguments + systemProperty(value))
    }

    public fun GradleRunner.andWithInfo() {
        withArguments(arguments + info())
    }

    public fun GradleRunner.andWithStacktrace() {
        withArguments(arguments + stacktrace())
    }

    public fun GradleRunner.andWithScan() {
        withArguments(arguments + scan())
    }

    public fun GradleRunner.andWithBuildCache() {
        withArguments(arguments + buildCache())
    }

    public fun GradleRunner.andWithNoBuildCache() {
        withArguments(arguments + noBuildCache())
    }

    public fun GradleRunner.andWithConfigurationCache() {
        withArguments(arguments + configurationCache())
    }

    public fun GradleRunner.andWithNoConfigurationCache() {
        withArguments(arguments + noConfigurationCache())
    }

    public fun GradleRunner.andWithConfigurationCacheProblemsWarn() {
        withArguments(arguments + configurationCacheProblemsWarn())
    }

    public val BuildResult.outputTrimmed: String
        get() = output.lines().joinToString("\n", transform = String::trim)
}
