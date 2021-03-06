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
                        api(gradleTestKit())
                        api(javierscKotlinStdlib())
                        api(libs.junit.jupiter.junitJupiterApi)
                        api(libs.junit.jupiter.junitJupiterParams)
                    }
                }
            }
        }
    }
}
