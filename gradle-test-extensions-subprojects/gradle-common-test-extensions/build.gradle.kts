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
                    api(hubdle.junit.jupiter.junitJupiterApi.moduleAsString())
                    api(hubdle.junit.jupiter.junitJupiterParams.moduleAsString())
                    api(platform(hubdle.junit.bom.asString()))
                }
            }
        }
    }
}
