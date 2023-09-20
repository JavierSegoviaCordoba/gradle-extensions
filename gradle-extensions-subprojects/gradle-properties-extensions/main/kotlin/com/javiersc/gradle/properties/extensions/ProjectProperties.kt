package com.javiersc.gradle.properties.extensions

import org.gradle.api.Project
import org.gradle.api.provider.Provider

/**
 * Get a property with the exact name or the name transformed to SCREAMING_CASE, for example,
 * `some.prop` or `SOME_PROP` with this ordering:
 * - Gradle properties from CLI
 * - Environment variables
 * - Properties from `gradle-local.properties` files
 * - Properties from `local.properties` files
 * - Properties from `gradle.properties` files
 *
 * For any kind of file the function tries to find the property in the file next to the project, so
 * it checks for the project file, later its parent, and so on until stop in the root directory.
 *
 * An example of priority
 * - `/foo/bar/gradle.properties`
 * - `/foo/gradle.properties`
 * - `/gradle.properties`
 *
 * In the previous example, `/foo/bar/gradle.properties` file has priority, if it wasn't there, then
 * `/foo/gradle.properties` would have the priority, and if it wasn't there, then
 * `/gradle.properties` would have the priority.
 */
public fun Project.getProperty(name: String): Provider<String> = provider {
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

public fun Project.getDoubleProperty(name: String): Provider<Double> =
    getProperty(name).map(String::toDouble)

public fun Project.getIntProperty(name: String): Provider<Int> =
    getProperty(name).map(String::toInt)

public fun Project.getLongProperty(name: String): Provider<Long> =
    getProperty(name).map(String::toLong)

public fun Project.getBooleanProperty(name: String): Provider<Boolean> =
    getProperty(name).map(String::toBoolean)

public fun Project.getStringProperty(name: String): Provider<String> = getProperty(name)

internal fun String.toSnakeCase(): String =
    map { char -> if (char.isUpperCase()) "_$char" else char.uppercaseChar() }
        .joinToString("")
        .replace(".", "_")
