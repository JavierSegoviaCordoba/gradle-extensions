package com.javiersc.gradle.testkit.test.extensions

import java.io.File

public fun resourceFile(resource: String): File =
    File(Thread.currentThread().contextClassLoader?.getResource(resource)?.toURI()!!)
