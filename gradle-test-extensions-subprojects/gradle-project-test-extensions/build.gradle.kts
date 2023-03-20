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
                    api(hubdle.javiersc.kotlin.kotlinStdlib)
                    api(hubdle.junit.jupiter.junitJupiterApi)
                    api(hubdle.junit.jupiter.junitJupiterParams)
                    api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                }
            }
        }
    }
}
