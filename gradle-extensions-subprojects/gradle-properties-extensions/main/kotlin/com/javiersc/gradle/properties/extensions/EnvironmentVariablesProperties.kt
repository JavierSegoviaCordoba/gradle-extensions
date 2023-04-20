package com.javiersc.gradle.properties.extensions

import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider

private const val EnvironmentVariables = "Environment Variables"

public fun Project.getEnvironmentVariable(name: String): Provider<String> = provider {
    val value: String? = System.getenv(name)
    if (value == null) propertyNotFound(name, EnvironmentVariables)
    value
}

public fun Settings.getEnvironmentVariable(name: String): Provider<String> =
    providers.provider {
        val value: String? = System.getenv(name)
        if (value == null) propertyNotFound(name, EnvironmentVariables)
        value
    }
