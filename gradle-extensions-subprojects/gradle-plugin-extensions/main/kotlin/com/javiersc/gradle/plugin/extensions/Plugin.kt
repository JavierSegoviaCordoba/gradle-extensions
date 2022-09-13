package com.javiersc.gradle.plugin.extensions

import org.gradle.api.Plugin as GradlePlugin

@Suppress("INAPPLICABLE_JVM_NAME")
public interface Plugin<T : Any> : GradlePlugin<T> {

    @JvmName("kotlinApply") public fun T.apply()

    @JvmName("javaApply") override fun apply(target: T): Unit = target.apply()
}
