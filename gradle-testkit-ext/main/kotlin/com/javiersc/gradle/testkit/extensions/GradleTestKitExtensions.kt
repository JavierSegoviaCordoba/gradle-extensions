package com.javiersc.gradle.testkit.extensions

import org.gradle.testkit.runner.GradleRunner

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
