plugins {
    `java-gradle-plugin`
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(gradleTestKit())

    api(libs.javiersc.kotlin.kotlinStdlib)
}
