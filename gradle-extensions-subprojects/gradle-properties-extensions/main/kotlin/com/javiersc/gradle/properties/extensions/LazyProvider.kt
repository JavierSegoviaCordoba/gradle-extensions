package com.javiersc.gradle.properties.extensions

import java.io.File
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.Provider

public inline fun <reified T : Any> Settings.provider(
    crossinline block: Settings.() -> T
): Provider<T> = providers.provider { block(this) }

public inline fun Settings.directoryProvider(
    crossinline block: Settings.() -> File
): Provider<Directory> = provider { objects.directoryProperty().fileValue(block(this)).get() }

public inline fun Settings.regularFileProvider(
    crossinline block: Settings.() -> File
): Provider<RegularFile> = provider { objects.fileProperty().fileValue(block(this)).get() }
