package com.javiersc.gradle.extensions

import org.gradle.api.Project

public val Project.isRootProject: Boolean
    get() = parent == null
