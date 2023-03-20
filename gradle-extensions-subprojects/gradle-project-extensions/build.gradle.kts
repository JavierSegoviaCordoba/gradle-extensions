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

                    implementation(libs.javiersc.semver.core)
                }
            }
        }
    }
}
