plugins {
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin { explicitApi() }

dependencies {
    api(libs.javiersc.kotlin.kotlinStdlib)

    api(gradleKotlinDsl())
    api(gradleTestKit())
}
