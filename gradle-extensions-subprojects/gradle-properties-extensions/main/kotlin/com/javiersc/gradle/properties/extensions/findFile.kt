package com.javiersc.gradle.properties.extensions

import java.io.File
import org.gradle.api.Project
import org.gradle.api.initialization.Settings

internal fun findFileRecursivelyInProjects(fileName: String, project: Project): File? {
    val file: File = project.file(fileName)
    val parentProject: Project? = project.parent
    return when {
        file.exists() -> file
        parentProject != null -> findFileRecursivelyInProjects(fileName, parentProject)
        else -> null
    }
}

internal fun findFileRecursivelyInSettings(fileName: String, settings: Settings): File? {
    val settingsLocalProps: File = settings.settingsDir.resolve(fileName)
    if (settingsLocalProps.exists()) return settingsLocalProps

    val rootProjectLocalProps: File = settings.rootDir.resolve(fileName)
    if (rootProjectLocalProps.exists()) return rootProjectLocalProps

    return null
}
