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

                    implementation(hubdle.javiersc.semver.core)
                }
            }
        }
    }
}
