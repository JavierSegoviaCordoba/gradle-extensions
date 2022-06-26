plugins {
    `java-gradle-plugin`
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin {
    explicitApi()
}

dependencies {
    api(libs.javiersc.kotlin.kotlinStdlib)

    implementation(gradleKotlinDsl())
    implementation(gradleTestKit())


    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.kotest.kotestAssertionsCore)
}
