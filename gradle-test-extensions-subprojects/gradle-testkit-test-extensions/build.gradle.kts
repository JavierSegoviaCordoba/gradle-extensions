plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
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
                    api(gradleKotlinDsl())
                    api(gradleTestKit())
                    api(javierscKotlinStdlib())
                    api(junitJupiterApi())
                    api(junitJupiterParams())
                    api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                }
            }
        }
    }
}
