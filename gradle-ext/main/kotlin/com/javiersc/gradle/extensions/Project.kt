package com.javiersc.gradle.extensions

import org.gradle.api.Project

public val Project.isRootProject: Boolean
    get() = parent == null

public val Project.module: String
    get() = "$group:$name"

public val Project.library: String
    get() = "$group:$name:$version"

public val Project.isSnapshot: Boolean
    get() = version.toString().endsWith("-SNAPSHOT", ignoreCase = true)

public val Project.isNotSnapshot: Boolean
    get() = !isSnapshot
