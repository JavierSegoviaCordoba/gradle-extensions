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
            if (isolated) withTestKitDir(createSandboxCacheDirectory(prefix))
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
