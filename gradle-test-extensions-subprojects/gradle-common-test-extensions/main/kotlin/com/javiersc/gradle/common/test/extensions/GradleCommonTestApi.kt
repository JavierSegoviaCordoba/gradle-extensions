package com.javiersc.gradle.common.test.extensions

import java.io.File

public interface GradleCommonTestApi {

    public fun resourceFile(resource: String): File =
        File(Thread.currentThread().contextClassLoader?.getResource(resource)?.toURI()!!)

    public fun projectProperty(value: String): String = "-P$value"

    public fun systemProperty(value: String): String = "-D$value"

    public fun info(): String = "--info"

    public fun stacktrace(): String = "--stacktrace"

    public fun scan(): String = "--scan"

    public fun buildCache(): String = "--build-cache"

    public fun noBuildCache(): String = "--no-build-cache"

    public fun configurationCache(): String = "--configuration-cache"

    public fun noConfigurationCache(): String = "--no-configuration-cache"

    public fun configurationCacheProblemsWarn(): String = "--configuration-cache-problems=warn"

    public fun buildValidPathName(path: String?): String =
        path?.replace("/", "--")?.replace("\\", "--") ?: ""
}
