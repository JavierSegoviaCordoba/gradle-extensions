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
                    api(hubdle.javiersc.kotlin.stdlib)
                    api(hubdle.junit.jupiter.junit.jupiter.api.moduleAsString())
                    api(hubdle.junit.jupiter.junit.jupiter.params.moduleAsString())
                    api(project.dependencies.platform(hubdle.junit.bom))
                    api(projects.gradleTestExtensionsSubprojects.gradleCommonTestExtensions)
                }
            }
        }
    }
}
