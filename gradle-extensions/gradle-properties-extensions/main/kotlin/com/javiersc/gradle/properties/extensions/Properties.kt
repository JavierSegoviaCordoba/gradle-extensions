package com.javiersc.gradle.properties.extensions

import java.io.File
import java.util.Properties
import org.gradle.api.Project

public val Project.localProperties: Properties?
    get() {
        val projectLocalProps: File = file("local.properties")
        val rootProjectLocalProps: File = rootProject.file("local.properties")
        return when {
            projectLocalProps.exists() -> {
                Properties().apply { load(projectLocalProps.inputStream()) }
            }
            rootProjectLocalProps.exists() -> {
                Properties().apply { load(rootProjectLocalProps.inputStream()) }
            }
            else -> null
        }
    }

public fun Project.getProperty(name: String): String =
    localProperties?.getProperty(name)
        ?: localProperties?.getProperty(name.toSnakeCase()) ?: System.getenv(name)
            ?: System.getenv(name.toSnakeCase()) ?: providers.gradleProperty(name).orNull
            ?: providers.gradleProperty(name.toSnakeCase()).orNull.run {
            checkNotNull(this) {
                val project = this@getProperty
                val userHomePath = System.getProperty("user.home")
                """
                    |The property `$name` is not available in any of the next sources:
                    |  - ${project.projectDir}${File.separator}local.properties
                    |  - ${project.rootDir}${File.separator}local.properties
                    |  - Environment variable
                    |  - ${project.projectDir}${File.separator}gradle.properties
                    |  - ${project.rootDir}${File.separator}gradle.properties
                    |  - $userHomePath${File.separator}.gradle${File.separator}gradle.properties
                    |  
                """.trimMargin()
            }
        }

public fun Project.getPropertyOrNull(name: String): String? =
    runCatching { getProperty(name) }.getOrNull()

public fun Project.getDoubleProperty(name: String): Double = getProperty(name).toDouble()

public fun Project.getDoublePropertyOrNull(name: String): Double? =
    getPropertyOrNull(name)?.toDoubleOrNull()

public fun Project.getIntProperty(name: String): Int = getProperty(name).toInt()

public fun Project.getIntPropertyOrNull(name: String): Int? = getPropertyOrNull(name)?.toIntOrNull()

public fun Project.getLongProperty(name: String): Long = getProperty(name).toLong()

public fun Project.getLongPropertyOrNull(name: String): Long? =
    getPropertyOrNull(name)?.toLongOrNull()

public fun Project.getBooleanProperty(name: String): Boolean = getPropertyOrNull(name).toBoolean()

public fun Project.getStringProperty(name: String): String = getProperty(name)

public fun Project.getStringPropertyOrNull(name: String): String? = getPropertyOrNull(name)

internal fun String.toSnakeCase(): String =
    map { char -> if (char.isUpperCase()) "_$char" else char.uppercaseChar() }
        .joinToString("")
        .replace(".", "_")
