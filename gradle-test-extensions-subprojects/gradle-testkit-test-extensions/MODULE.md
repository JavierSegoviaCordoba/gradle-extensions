# Module gradle-testkit-test-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-testkit-test-extensions:$version")
}
```

### Usage

```kotlin
gradleTestKitTest {
    gradlew("someTask")
    
    withArguments("someTaskOther")
    testBuildCache()
    testConfigurationCache()
}
```
