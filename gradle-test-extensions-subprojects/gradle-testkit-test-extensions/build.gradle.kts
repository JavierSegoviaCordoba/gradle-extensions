plugins {
    `java-gradle-plugin`
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin {
    explicitApi()
    sourceSets.all {
        languageSettings {
            optIn("kotlin.ExperimentalStdlibApi")
        }
    }
}

configureJvmTarget()

dependencies {
    api(gradleKotlinDsl())
    api(gradleTestKit())
    api(libs.javiersc.kotlin.kotlinStdlib)
    api(libs.junit.jupiter.junitJupiterApi)
    api(libs.junit.jupiter.junitJupiterParams)
}
