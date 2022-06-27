plugins {
    `kotlin-jvm`
    `javiersc-kotlin-config`
    `javiersc-publish`
}

kotlin {
    explicitApi()
}

dependencies {
    api(projects.gradleExtensions.gradleLoggingExtensions)
    api(projects.gradleExtensions.gradleMiscellaneaExtensions)
    api(projects.gradleExtensions.gradleProjectExtensions)
    api(projects.gradleExtensions.gradlePropertiesExtensions)
    api(projects.gradleExtensions.gradleTasksExtensions)
    api(projects.gradleExtensions.gradleVersionCatalogExtensions)
}
