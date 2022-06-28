plugins {
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin {
    explicitApi()
}

configureJvmTarget()

dependencies {
    api(gradleKotlinDsl())
    api(libs.javiersc.kotlin.kotlinStdlib)

    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.kotest.kotestAssertionsCore)
}
