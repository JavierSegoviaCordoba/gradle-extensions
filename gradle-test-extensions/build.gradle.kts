plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        gradle {
            plugin {
                features {
                    extendedGradle(enabled = false)
                }
                main {
                    dependencies {
                        api(gradleKotlinDsl())
                        api(javierscKotlinStdlib())
                        api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                        api(projects.gradleTestExtensionsSubprojects.gradleProjectTestExtensions)
                        api(projects.gradleTestExtensionsSubprojects.gradleTestkitTestExtensions)
                    }
                }
            }
        }
    }
}
