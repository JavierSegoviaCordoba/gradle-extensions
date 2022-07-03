package com.javiersc.gradle.properties.extensions

import java.io.File
import org.gradle.api.initialization.Settings

public fun Settings.getProperty(name: String): String =
    localProperties?.getProperty(name)
        ?: localProperties?.getProperty(name.toSnakeCase()) ?: System.getenv(name)
            ?: System.getenv(name.toSnakeCase()) ?: providers.gradleProperty(name).orNull
            ?: providers.gradleProperty(name.toSnakeCase()).orNull.run {
            checkNotNull(this) {
                val settings = this@getProperty
                val userHomePath = System.getProperty("user.home")
                """
                    |The property `$name` is not available in any of the next sources:
                    |  - ${settings.settingsDir}${File.separator}local.properties
                    |  - ${settings.rootDir}${File.separator}local.properties
                    |  - Environment variable
                    |  - ${settings.settingsDir}${File.separator}gradle.properties
                    |  - $userHomePath${File.separator}.gradle${File.separator}gradle.properties
                    |  
                """.trimMargin()
            }
        }

public fun Settings.getPropertyOrNull(name: String): String? =
    runCatching { getProperty(name) }.getOrNull()

public fun Settings.getDoubleProperty(name: String): Double = getProperty(name).toDouble()

public fun Settings.getDoublePropertyOrNull(name: String): Double? =
    getPropertyOrNull(name)?.toDoubleOrNull()

public fun Settings.getIntProperty(name: String): Int = getProperty(name).toInt()

public fun Settings.getIntPropertyOrNull(name: String): Int? =
    getPropertyOrNull(name)?.toIntOrNull()

public fun Settings.getLongProperty(name: String): Long = getProperty(name).toLong()

public fun Settings.getLongPropertyOrNull(name: String): Long? =
    getPropertyOrNull(name)?.toLongOrNull()

public fun Settings.getBooleanProperty(name: String): Boolean = getPropertyOrNull(name).toBoolean()

public fun Settings.getStringProperty(name: String): String = getProperty(name)

public fun Settings.getStringPropertyOrNull(name: String): String? = getPropertyOrNull(name)
