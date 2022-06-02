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
    implementation(gradleKotlinDsl())
    implementation(gradleTestKit())

    api(libs.javiersc.kotlin.kotlinStdlib)
}
