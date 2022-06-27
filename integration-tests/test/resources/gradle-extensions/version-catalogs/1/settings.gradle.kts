dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("pluginLibs") { from(files("gradle/pluginLibs.versions.toml")) }
    }
}
