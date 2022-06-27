import com.javiersc.gradle.extensions.version.catalogs.getLibraryByModule
import com.javiersc.gradle.extensions.version.catalogs.getLibraryByModuleOrNull
import com.javiersc.gradle.extensions.version.catalogs.getLibraryByGroup
import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("fake.plugin")
}

val libraryByModule =
    the<VersionCatalogsExtension>().getLibraryByModule("io.kotest:kotest-assertions-core")

println("Library by module: $libraryByModule")

val libraryByModuleNull =
    the<VersionCatalogsExtension>().getLibraryByModuleOrNull("io.kotest:kotest-assertions-core-no")

println("Null library by module: $libraryByModuleNull")

val librariesByGroup =
    the<VersionCatalogsExtension>().getLibraryByGroup("io.kotest")

println("Libraries by group: $librariesByGroup")
