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
    ":gradle-extensions-subprojects:gradle-logging-extensions",
    ":gradle-extensions-subprojects:gradle-miscellanea-extensions",
    ":gradle-extensions-subprojects:gradle-project-extensions",
    ":gradle-extensions-subprojects:gradle-properties-extensions",
    ":gradle-extensions-subprojects:gradle-tasks-extensions",
    ":gradle-extensions-subprojects:gradle-version-catalog-extensions",
)

include(":gradle-test-extensions")
include(
    ":gradle-test-extensions-subprojects:gradle-testkit-test-extensions",
)

include(":integration-tests")
