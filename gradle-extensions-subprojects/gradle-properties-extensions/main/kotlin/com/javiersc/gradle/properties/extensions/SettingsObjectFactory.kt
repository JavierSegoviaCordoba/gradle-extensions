package com.javiersc.gradle.properties.extensions

import org.gradle.api.initialization.Settings
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.support.serviceOf

public val Settings.objects: ObjectFactory
    get() = serviceOf<ObjectFactory>()
