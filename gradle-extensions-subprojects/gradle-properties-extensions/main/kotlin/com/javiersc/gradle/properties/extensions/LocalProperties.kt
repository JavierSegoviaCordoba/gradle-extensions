package com.javiersc.gradle.properties.extensions

import java.io.File
import java.util.Properties
import org.gradle.api.Project
import org.gradle.api.initialization.Settings

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

public val Settings.localProperties: Properties?
    get() {
        val settingsLocalProps: File = settingsDir.resolve("local.properties")
        val rootProjectLocalProps: File = rootDir.resolve("local.properties")
        return when {
            settingsLocalProps.exists() -> {
                Properties().apply { load(settingsLocalProps.inputStream()) }
            }
            rootProjectLocalProps.exists() -> {
                Properties().apply { load(rootProjectLocalProps.inputStream()) }
            }
            else -> null
        }
    }
