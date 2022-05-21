package com.javiersc.gradle.testkit.extensions

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome

fun gradleTestKitTest(
    sandboxPath: String? = null,
    withDebug: Boolean = true,
    withPluginClasspath: Boolean = true,
    withArgumentsFromTXT: Boolean = false,
    prefix: String = sandboxPath ?: "",
    isolated: Boolean = false,
    test: GradleRunner.() -> Unit,
) {
    val projectDir = createSandboxDirectory(prefix)

    sandboxPath?.copyResourceTo(projectDir)

    test(
        GradleRunner.create().apply {
            withDebug(withDebug)
            if (withPluginClasspath) withPluginClasspath()
            if (isolated) withTestKitDir(createSandboxIsolatedDirectory(prefix))
            withProjectDir(projectDir)
            if (withArgumentsFromTXT) withArgumentsFromTXT()
        }
    )
}

fun gradleConfigurationCacheTestKitTest(
    sandboxPath: String? = null,
    withDebug: Boolean = true,
    withPluginClasspath: Boolean = true,
    withArgumentsFromTXT: Boolean = false,
    prefix: String = sandboxPath ?: "",
    isolated: Boolean = false,
    preTest: GradleRunner.() -> Unit,
) {
    gradleTestKitTest(
        sandboxPath,
        withDebug,
        withPluginClasspath,
        withArgumentsFromTXT,
        prefix,
        isolated,
    ) {
        preTest(this)
        val task =
            checkNotNull(arguments.firstOrNull()) {
                "There is not a task in the arguments to check if configuration cache works"
            }
        andWithConfigurationCache()
        andWithNoBuildCache()
        build()

        val result = build()

        if (!result.output.contains("Reusing configuration cache")) {
            error("Configuration cache is not working")
        }
        val outcome =
            checkNotNull(result.task(task)) { "The outcome for the task $task is null" }.outcome

        if (outcome != TaskOutcome.UP_TO_DATE) {
            error("The outcome is $outcome and must be UP-TO-DATE")
        }
    }
}

fun gradleBuildCacheTestKitTest(
    sandboxPath: String? = null,
    withDebug: Boolean = true,
    withPluginClasspath: Boolean = true,
    withArgumentsFromTXT: Boolean = false,
    prefix: String = sandboxPath ?: "",
    isolated: Boolean = true,
    preTest: GradleRunner.() -> Unit,
) {
    gradleTestKitTest(
        sandboxPath,
        withDebug,
        withPluginClasspath,
        withArgumentsFromTXT,
        prefix,
        isolated,
    ) {
        preTest(this)
        val task =
            checkNotNull(arguments.firstOrNull()) {
                "There is not a task in the arguments to check if configuration cache works"
            }
        andWithBuildCache()
        build()
        cleanBuildDirectory()

        val result = build()

        val outcome =
            checkNotNull(result.task(task)) { "The outcome for the task $task is null" }.outcome

        if (outcome != TaskOutcome.FROM_CACHE) {
            error("The outcome is $outcome and must be FROM-CACHE")
        }
    }
}

fun GradleRunner.withArgumentsFromTXT() {
    withArguments(argumentsTxt)
}

fun GradleRunner.clean() {
    val previousArgs: List<String> = arguments.toList()
    withArguments("clean").build()
    withArguments(previousArgs)
}

fun GradleRunner.cleanBuildDirectory() {
    for (file in projectDir.walkTopDown()) {
        if (file.isDirectory && file.name == "build") file.deleteRecursively()
    }
}

fun GradleRunner.info(): String = "--info"

fun GradleRunner.andWithInfo() {
    withArguments(arguments + info())
}

fun GradleRunner.stacktrace(): String = "--stacktrace"

fun GradleRunner.andWithStacktrace() {
    withArguments(arguments + stacktrace())
}

fun GradleRunner.scan(): String = "--scan"

fun GradleRunner.andWithScan() {
    withArguments(arguments + scan())
}

fun GradleRunner.buildCache(): String = "--build-cache"

fun GradleRunner.andWithBuildCache() {
    withArguments(arguments + buildCache())
}

fun GradleRunner.noBuildCache(): String = "--no-build-cache"

fun GradleRunner.andWithNoBuildCache() {
    withArguments(arguments + noBuildCache())
}

fun GradleRunner.configurationCache(): String = "--configuration-cache"

fun GradleRunner.andWithConfigurationCache() {
    withArguments(arguments + configurationCache())
}

fun GradleRunner.noConfigurationCache(): String = "--no-configuration-cache"

fun GradleRunner.andWithNoConfigurationCache() {
    withArguments(arguments + noConfigurationCache())
}

fun GradleRunner.configurationCacheProblemsWarn(): String = "--configuration-cache-problems=warn"

fun GradleRunner.andWithConfigurationCacheProblemsWarn() {
    withArguments(arguments + configurationCacheProblemsWarn())
}
