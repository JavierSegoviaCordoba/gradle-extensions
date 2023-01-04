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
                    api(gradleKotlinDsl())
                    api(javierscKotlinStdlib())

                    implementation(libs.javiersc.semver.core)
                }
            }
        }
    }
}
