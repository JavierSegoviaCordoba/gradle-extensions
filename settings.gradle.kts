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

    versionCatalogs { create("pluginLibs") { from(files("gradle/pluginLibs.versions.toml")) } }
}

include(":gradle-extensions")
include(
    ":gradle-extensions:gradle-logging-extensions",
    ":gradle-extensions:gradle-miscellanea-extensions",
    ":gradle-extensions:gradle-project-extensions",
    ":gradle-extensions:gradle-properties-extensions",
    ":gradle-extensions:gradle-tasks-extensions",
    ":gradle-extensions:gradle-version-catalog-extensions",
)

include(":gradle-test-extensions")
include(
    ":gradle-test-extensions:gradle-testkit-test-extensions",
)

include(":integration-tests")
