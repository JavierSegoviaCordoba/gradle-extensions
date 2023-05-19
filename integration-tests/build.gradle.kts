hubdle {
    config {
        explicitApi()
    }

    kotlin {
        jvm {
            features {
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

            main {
                dependencies {
                    implementation(gradleKotlinDsl())
                    implementation(projects.gradleExtensions)
                    implementation(projects.gradleTestExtensions)
                }
            }
        }
    }
}
