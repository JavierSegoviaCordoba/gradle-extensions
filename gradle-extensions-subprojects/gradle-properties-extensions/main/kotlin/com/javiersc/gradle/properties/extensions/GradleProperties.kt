package com.javiersc.gradle.properties.extensions

import java.util.Properties
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider

private const val GradlePropertiesFileName = "gradle.properties"

public val Project.gradleProperties: Properties?
    get() = findFileRecursivelyInProjects(GradlePropertiesFileName, this)?.toProperties()

public fun Project.getGradleProperty(name: String): Provider<String> = provider {
    val property: String? =
        gradle.startParameter.projectProperties[name]
            ?: gradleProperties?.getProperty(name) ?: providers.gradleProperty(name).orNull
    if (property != null) propertyNotFound(name, GradlePropertiesFileName)
    property
}

public val Settings.gradleProperties: Properties?
    get() = findFileRecursivelyInSettings(GradlePropertiesFileName, this)?.toProperties()

public fun Settings.getGradleProperty(name: String): Provider<String> =
    providers.provider {
        val property: String? =
            gradle.startParameter.projectProperties[name]
                ?: gradleProperties?.getProperty(name) ?: providers.gradleProperty(name).orNull
        if (property != null) propertyNotFound(name, GradlePropertiesFileName)
        property
    }
