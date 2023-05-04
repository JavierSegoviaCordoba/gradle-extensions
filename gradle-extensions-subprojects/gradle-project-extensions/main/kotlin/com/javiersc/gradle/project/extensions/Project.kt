package com.javiersc.gradle.project.extensions

import org.gradle.api.Project

public val Project.isRootProject: Boolean
    get() = parent == null

public val Project.module: String
    get() = "$group:$name"

public val Project.library: String
    get() = "$group:$name:$version"

public operator fun Project.invoke(action: Project.() -> Unit) {
    action(this)
}

public fun Project.withPlugins(vararg pluginIds: String, action: Project.() -> Unit) {
    check(pluginIds.isNotEmpty()) { "pluginIds must not be empty" }

    val appliedPluginIds: MutableList<String> = mutableListOf()

    for (pluginId in pluginIds) {
        pluginManager.withPlugin(pluginId) { appliedPluginIds.add(pluginId) }
    }

    pluginManager.withPlugin(pluginIds.first()) {
        if (pluginIds.toSortedSet() == appliedPluginIds.toSortedSet()) {
            action(this)
        }
    }
}
