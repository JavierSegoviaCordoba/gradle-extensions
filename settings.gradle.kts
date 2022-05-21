rootProject.name = providers.gradleProperty("project.name").get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)

    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    versionCatalogs {
        create("pluginLibs") { from(files("gradle/pluginLibs.versions.toml")) }
    }
}

include(":gradle-ext")
include(":gradle-testkit-ext")
include(":gradle-testkit-ext-integration-tests")
