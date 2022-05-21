package com.javiersc.gradle.testkit.extensions

import java.io.File
import org.gradle.testkit.runner.GradleRunner

fun gradleTestKitTest(
    sandboxPath: String? = null,
    arguments: List<String>? = null,
    withDebug: Boolean = true,
    withPluginClasspath: Boolean = true,
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
            withArguments(arguments ?: argumentsTxt)
        }
    )
}

fun GradleRunner.cleanBuildDirectory(): Boolean = File("${projectDir}/build").deleteRecursively()

fun GradleRunner.withInfo() {
    withArguments(arguments + "--info")
}

fun GradleRunner.withStacktrace() {
    withArguments(arguments + "--stacktrace")
}

fun GradleRunner.withScan() {
    withArguments(arguments + "--scan")
}

fun GradleRunner.withBuildCache() {
    withArguments(arguments + "--build-cache")
}

fun GradleRunner.withNoBuildCache() {
    withArguments(arguments + "--no-build-cache")
}

fun GradleRunner.withConfigurationCache() {
    withArguments(arguments + "--configuration-cache")
}

fun GradleRunner.withNoConfigurationCache() {
    withArguments(arguments + "--no-configuration-cache")
}

fun GradleRunner.withConfigurationCacheProblemsWarn() {
    withArguments(arguments + "--configuration-cache-problems=warn")
}
