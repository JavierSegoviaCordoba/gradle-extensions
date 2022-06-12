@file:Suppress("UNCHECKED_CAST")

package com.javiersc.gradle.extensions

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import org.gradle.api.provider.Provider
import org.gradle.util.GradleVersion.current
import org.gradle.util.GradleVersion.version

// TODO: Remove it when Gradle 7.0 adoption is very high
public fun <S> forUseAtConfigurationTime(provider: Provider<S>): Provider<S> {
    return if (current() >= version("6.5") && current() < version("7.0")) {
        try {
            val method: Method = Provider::class.java.getMethod("forUseAtConfigurationTime")
            method(provider) as Provider<S>
        } catch (e: Exception) {
            val shouldThrowRuntimeException =
                e is NoSuchMethodException ||
                    e is IllegalAccessException ||
                    e is InvocationTargetException
            if (shouldThrowRuntimeException) {
                throw RuntimeException("Could not mark provider usage for configuration time.", e)
            } else {
                throw e
            }
        }
    } else provider
}
