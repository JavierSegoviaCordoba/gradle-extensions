package com.javiersc.gradle.properties.extensions

import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.property

public inline fun <reified T> Project.property(crossinline block: Project.() -> T): Property<T> =
    objects.property<T>().convention(provider { block(this) })

public inline fun <reified T> Project.listProperty(
    crossinline block: Project.() -> List<T>
): ListProperty<T> = objects.listProperty<T>().convention(project.provider { block(this) })
