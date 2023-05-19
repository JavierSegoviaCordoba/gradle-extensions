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
                    api(gradleKotlinDsl())
                    api(hubdle.javiersc.kotlin.kotlinStdlib)
                    api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                    api(projects.gradleTestExtensionsSubprojects.gradleProjectTestExtensions)
                    api(projects.gradleTestExtensionsSubprojects.gradleTestkitTestExtensions)
                }
            }
        }
    }
}
