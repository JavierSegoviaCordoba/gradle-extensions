plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
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
                    api(javierscKotlinStdlib())
                    api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                    api(projects.gradleTestExtensionsSubprojects.gradleProjectTestExtensions)
                    api(projects.gradleTestExtensionsSubprojects.gradleTestkitTestExtensions)
                }
            }
        }
    }
}
