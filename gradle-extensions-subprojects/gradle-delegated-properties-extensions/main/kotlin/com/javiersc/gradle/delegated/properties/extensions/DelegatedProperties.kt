package com.javiersc.gradle.delegated.properties.extensions

import kotlin.reflect.KProperty
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

public abstract class DelegatedProperty<T> {

    internal abstract val property: Property<T>
}

public operator fun <T> DelegatedProperty<T>.getValue(thisRef: Any?, property: KProperty<*>): T =
    this.property.get()

public operator fun <T> DelegatedProperty<T>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: T
) {
    this.property.convention(value)
}

public inline fun <reified T> ObjectFactory.delegatedProperty(): DelegatedProperty<T> =
    object : DelegatedProperty<T>() {
        override val property: Property<T> = property(T::class.java)
    }

public inline fun <reified T> Project.delegatedProperty(): DelegatedProperty<T> =
    objects.delegatedProperty()

public inline fun <reified T> ObjectFactory.delegatedProperty(initial: T): DelegatedProperty<T> =
    object : DelegatedProperty<T>() {
        override val property: Property<T> = property(T::class.java).convention(initial)
    }

public inline fun <reified T> Project.delegatedProperty(initial: T): DelegatedProperty<T> =
    objects.delegatedProperty(initial)
