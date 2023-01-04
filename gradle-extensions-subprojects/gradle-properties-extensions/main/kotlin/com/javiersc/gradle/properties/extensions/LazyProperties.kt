package com.javiersc.gradle.properties.extensions

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

public inline fun <reified T> Project.property(crossinline block: Project.() -> T): Property<T> =
    objects.property<T>().convention(provider { block(this) })
