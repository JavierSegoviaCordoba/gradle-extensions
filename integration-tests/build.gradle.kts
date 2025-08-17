hubdle {
    config {
        explicitApi()
    }

    kotlin {
        jvm {
            features { //
                kotest()
            }
            main {
                dependencies {
                    implementation(gradleKotlinDsl())
                    implementation(projects.gradleExtensions)
                    implementation(projects.gradleTestExtensions)
                }
            }
        }
    }

    gradle {
        plugin {
            extendedGradle.set(false)

            gradlePlugin {
                plugins {
                    create("FakePlugin") {
                        id = "fake.plugin"
                        displayName = "Fake Plugin"
                        description = "Fake Plugin for testing purposes"
                        implementationClass = "com.javiersc.integration.tests.FakePlugin"
                    }
                }
            }
        }
    }
}
