plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        jvm {
            features {
                extendedGradle(enabled = false)
            }
            main {
                dependencies {
                    api(javierscKotlinStdlib())
                    api(projects.gradleExtensionsSubprojects.gradleDelegatedPropertiesExtensions)
                    api(projects.gradleExtensionsSubprojects.gradleLoggingExtensions)
                    api(projects.gradleExtensionsSubprojects.gradleMiscellaneaExtensions)
                    api(projects.gradleExtensionsSubprojects.gradlePluginExtensions)
                    api(projects.gradleExtensionsSubprojects.gradleProjectExtensions)
                    api(projects.gradleExtensionsSubprojects.gradlePropertiesExtensions)
                    api(projects.gradleExtensionsSubprojects.gradleTasksExtensions)
                    api(projects.gradleExtensionsSubprojects.gradleVersionCatalogExtensions)
                }
            }
        }
    }
}
