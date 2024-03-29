hubdle {
    config {
        analysis()
        coverage()
        documentation {
            api()
        }
        explicitApi()
        publishing()
    }
    kotlin {
        jvm {
            main {
                dependencies {
                    api(hubdle.javiersc.kotlin.stdlib)
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
