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
                        api(junitJupiterApi())
                        api(junitJupiterParams())
                        api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                    }
                }
            }
        }
    }
}
