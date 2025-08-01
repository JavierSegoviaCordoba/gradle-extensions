package com.javiersc.gradle.properties.extensions

import java.io.File
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.initialization.Settings
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.SetProperty
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.setProperty

public inline fun <reified T : Any> Project.property(
    crossinline block: Project.() -> T
): Property<T> = objects.property<T>().convention(provider { block(this) })

public inline fun <reified T : Any> Settings.property(
    crossinline block: Settings.() -> T
): Property<T> = objects.property<T>().convention(provider { block(this) })

public inline fun <reified T : Any> Project.listProperty(
    crossinline block: Project.() -> List<T>
): ListProperty<T> = objects.listProperty<T>().convention(provider { block(this) })

public inline fun <reified T : Any> Settings.listProperty(
    crossinline block: Settings.() -> List<T>
): ListProperty<T> = objects.listProperty<T>().convention(provider { block(this) })

public inline fun <reified T : Any> Project.setProperty(
    crossinline block: Project.() -> Set<T>
): SetProperty<T> = objects.setProperty<T>().convention(provider { block(this) })

public inline fun <reified T : Any> Settings.setProperty(
    crossinline block: Settings.() -> Set<T>
): SetProperty<T> = objects.setProperty<T>().convention(provider { block(this) })

public inline fun Settings.directoryProperty(
    crossinline block: Settings.() -> File
): DirectoryProperty = objects.directoryProperty().convention(directoryProvider(block))

public inline fun Settings.fileProperty(
    crossinline block: Settings.() -> File
): RegularFileProperty = objects.fileProperty().convention(regularFileProvider(block))

public inline fun Settings.regularFileProperty(
    crossinline block: Settings.() -> File
): RegularFileProperty = objects.fileProperty().convention(regularFileProvider(block))
