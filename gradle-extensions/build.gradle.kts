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
    api(projects.gradleExtensionsSubprojects.gradleLoggingExtensions)
    api(projects.gradleExtensionsSubprojects.gradleMiscellaneaExtensions)
    api(projects.gradleExtensionsSubprojects.gradleProjectExtensions)
    api(projects.gradleExtensionsSubprojects.gradlePropertiesExtensions)
    api(projects.gradleExtensionsSubprojects.gradleTasksExtensions)
    api(projects.gradleExtensionsSubprojects.gradleVersionCatalogExtensions)
}
