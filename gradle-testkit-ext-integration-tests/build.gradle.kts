import com.gradle.publish.PublishTask

plugins {
    `java-gradle-plugin`
    `kotlin-jvm`
    `javiersc-kotlin-config`
}

gradlePlugin {
    plugins {
        create("FakePlugin") {
            id = "com.javiersc.testkit.fake"
            displayName = "Fake Plugin"
            description = "Fake Plugin for testing purposes"
            implementationClass = "com.javiersc.gradle.testkit.extensions.integration.tests.FakePlugin"
        }
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(projects.gradleExt)

    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.kotest.kotestAssertionsCore)

    testImplementation(projects.gradleTestkitExt)
}
