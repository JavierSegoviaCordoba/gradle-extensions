package com.javiersc.gradle.miscellanea.extensions

import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependency

public val Provider<PluginDependency>.pluginLibrary: Provider<String>
    get() = map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }
