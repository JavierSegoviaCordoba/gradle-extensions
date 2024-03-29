@file:Suppress("UnusedReceiverParameter")

package com.javiersc.gradle.extensions.version.catalogs

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependency

public fun VersionCatalogsExtension.getLibrariesByGroup(
    group: String
): List<MinimalExternalModuleDependency> =
    catalogNamesWithLibsAtFirst.flatMap(::getLibraries).filter { library ->
        library.module.group == group
    }

public fun VersionCatalogsExtension.getLibraryByModule(
    module: String
): MinimalExternalModuleDependency =
    catalogNamesWithLibsAtFirst.flatMap(::getLibraries).first { library ->
        "${library.module}" == module
    }

public fun VersionCatalogsExtension.getLibraryByModuleOrNull(
    libraryModule: String
): MinimalExternalModuleDependency? = runCatching { getLibraryByModule(libraryModule) }.getOrNull()

public fun VersionCatalogsExtension.getLibraries(
    catalog: VersionCatalog
): List<MinimalExternalModuleDependency> =
    catalog.libraryAliases.toList().mapNotNull { catalog.findLibrary(it).get().orNull }

public fun VersionCatalogsExtension.getLibraries(
    catalogName: String
): List<MinimalExternalModuleDependency> {
    val catalog: VersionCatalog = named(catalogName)
    val aliases: List<String> = catalog.libraryAliases.toList()
    return aliases.mapNotNull { catalog.findLibrary(it).get().orNull }
}

public val VersionCatalogsExtension.catalogNamesWithLibsAtFirst: List<String>
    get() = catalogNames.sorted().sortedByDescending { it == "libs" }

public val PluginDependency.artifact: String
    get() = "$pluginId:$pluginId.gradle.plugin:${version.requiredVersion}"

public val Provider<PluginDependency>.artifact: Provider<String>
    get() = map(PluginDependency::artifact)

public val PluginDependency.module: String
    get() = "$pluginId:$pluginId.gradle.plugin"

public val Provider<PluginDependency>.module: Provider<String>
    get() = map(PluginDependency::module)
