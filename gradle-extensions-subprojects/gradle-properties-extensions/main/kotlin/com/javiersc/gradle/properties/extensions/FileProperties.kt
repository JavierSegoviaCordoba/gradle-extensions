package com.javiersc.gradle.properties.extensions

import java.io.File
import java.util.Properties

public fun File.toProperties(): Properties =
    Properties().apply { this@toProperties.inputStream().use(::load) }
