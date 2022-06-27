plugins {
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin { explicitApi() }

dependencies {
    api(gradleKotlinDsl())
    api(libs.javiersc.kotlin.kotlinStdlib)
}
