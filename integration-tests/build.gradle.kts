plugins {
    `java-gradle-plugin`
    `kotlin-jvm`
    `javiersc-kotlin-config`
}

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

dependencies {
    implementation(gradleKotlinDsl())

    implementation(projects.gradleExtensions)
    implementation(projects.gradleTestExtensions)

    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.kotest.kotestAssertionsCore)
}
