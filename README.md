![Kotlin version](https://img.shields.io/badge/kotlin-1.8.20-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.gradle/gradle-extensions?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/gradle/gradle-extensions/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.gradle/gradle-extensions?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/gradle/gradle-extensions/)

[![Build](https://img.shields.io/github/actions/workflow/status/JavierSegoviaCordoba/gradle-extensions/build-kotlin.yaml?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/gradle-extensions/tree/main)
[![Coverage](https://img.shields.io/sonar/coverage/com.javiersc.gradle:gradle-extensions?label=Coverage&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.gradle:gradle-extensions)
[![Quality](https://img.shields.io/sonar/quality_gate/com.javiersc.gradle:gradle-extensions?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.gradle:gradle-extensions)
[![Tech debt](https://img.shields.io/sonar/tech_debt/com.javiersc.gradle:gradle-extensions?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=com.javiersc.gradle:gradle-extensions)

# Gradle Extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-extensions:$version")
    // or any subproject
    implementation("com.javiersc.gradle:gradle-logging-extensions:$version")
    implementation("com.javiersc.gradle:gradle-miscellanea-extensions:$version")
    implementation("com.javiersc.gradle:gradle-plugin-extensions:$version")
    implementation("com.javiersc.gradle:gradle-project-extensions:$version")
    implementation("com.javiersc.gradle:gradle-properties-extensions:$version")
    implementation("com.javiersc.gradle:gradle-tasks-extensions:$version")
    implementation("com.javiersc.gradle:gradle-version-catalog-extensions:$version")
    
    testImplementation("com.javiersc.gradle:gradle-test-extensions:$version")
    // or any subproject
    testImplementation("com.javiersc.gradle:gradle-common-test-extensions:$version")
    testImplementation("com.javiersc.gradle:gradle-project-test-extensions:$version")
    testImplementation("com.javiersc.gradle:gradle-testkit-test-extensions:$version")
}
```
