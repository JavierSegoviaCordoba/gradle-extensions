package com.javiersc.gradle.properties.extensions

import java.util.Properties
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider

private const val GradleLocalPropertiesFileName = "gradle-local.properties"

private const val LocalPropertiesFileName = "local.properties"

public val Project.gradleLocalProperties: Properties?
    get() = findFileRecursivelyInProjects(GradleLocalPropertiesFileName, this)?.toProperties()

public fun Project.getGradleLocalProperty(name: String): Provider<String> = provider {
    gradleLocalProperties?.getProperty(name)?.also {
        propertyNotFound(name, GradleLocalPropertiesFileName)
    }
}

public val Settings.gradleLocalProperties: Properties?
    get() = findFileRecursivelyInSettings(GradleLocalPropertiesFileName, this)?.toProperties()

public fun Settings.getGradleLocalProperty(name: String): Provider<String> =
    providers.provider {
        gradleLocalProperties?.getProperty(name)?.also {
            propertyNotFound(name, GradleLocalPropertiesFileName)
        }
    }

public val Project.localProperties: Properties?
    get() = findFileRecursivelyInProjects(LocalPropertiesFileName, this)?.toProperties()

public fun Project.getLocalProperty(name: String): Provider<String> = provider {
    localProperties?.getProperty(name)?.also { propertyNotFound(name, LocalPropertiesFileName) }
}

public val Settings.localProperties: Properties?
    get() = findFileRecursivelyInSettings(LocalPropertiesFileName, this)?.toProperties()

public fun Settings.getLocalProperty(name: String): Provider<String> =
    providers.provider {
        localProperties?.getProperty(name)?.also { propertyNotFound(name, LocalPropertiesFileName) }
    }
