package com.javiersc.gradle.properties.extensions

import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider

public fun Settings.getProperty(name: String): Provider<String> =
    providers.provider {
        val projectProperties: MutableMap<String, String> = gradle.startParameter.projectProperties
        val cliProperty: String? = projectProperties[name] ?: projectProperties[name.toSnakeCase()]

        cliProperty //
            ?: getEnvironmentVariable(name).orNull //
             ?: getEnvironmentVariable(name.toSnakeCase()).orNull //
             ?: getGradleLocalProperty(name).orNull //
             ?: getGradleLocalProperty(name.toSnakeCase()).orNull //
             ?: getLocalProperty(name).orNull //
             ?: getLocalProperty(name.toSnakeCase()).orNull //
             ?: getGradleProperty(name).orNull //
             ?: getGradleProperty(name.toSnakeCase()).orNull //
    }

public fun Settings.getDoubleProperty(name: String): Provider<Double> =
    getProperty(name).map(String::toDouble)

public fun Settings.getIntProperty(name: String): Provider<Int> =
    getProperty(name).map(String::toInt)

public fun Settings.getLongProperty(name: String): Provider<Long> =
    getProperty(name).map(String::toLong)

public fun Settings.getBooleanProperty(name: String): Provider<Boolean> =
    getProperty(name).map(String::toBoolean)

public fun Settings.getStringProperty(name: String): Provider<String> = getProperty(name)
