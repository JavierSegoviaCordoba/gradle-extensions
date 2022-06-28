plugins {
    `java-gradle-plugin`
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
    api(gradleTestKit())
    api(libs.javiersc.kotlin.kotlinStdlib)
    api(projects.gradleTestExtensions.gradleTestkitTestExtensions)
}
