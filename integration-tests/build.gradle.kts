plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
    }
    kotlin {
        gradle {
            plugin {
                features {
                    extendedGradle(enabled = false)
                }
                main {
                    dependencies {
                        implementation(gradleKotlinDsl())

                        implementation(projects.gradleExtensions)
                        implementation(projects.gradleTestExtensions)
                    }
                }

                rawConfig {
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
    }
}
