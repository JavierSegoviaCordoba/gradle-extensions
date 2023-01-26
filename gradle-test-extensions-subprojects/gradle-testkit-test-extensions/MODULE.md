# Module gradle-testkit-test-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-testkit-test-extensions:$version")
}
```

### Usage

### Usage

```kotlin
class FooTest : GradleTestKitTest() {

    @Test
    fun test() {
        gradleTestKitTest {
            // Do tests
        }
    }
}
```
