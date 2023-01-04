package com.javiersc.gradle.project.extensions

import org.gradle.api.Project

public val Project.isRootProject: Boolean
    get() = parent == null

public val Project.module: String
    get() = "$group:$name"

public val Project.library: String
    get() = "$group:$name:$version"
