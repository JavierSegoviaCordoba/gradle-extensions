# Module gradle-project-test-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-project-test-extensions:$version")
}
```

### Usage

```kotlin

class FooTest : GradleProjectTest() {
    
    @Test
    fun test() {
        gradleProjectTest {
            // Do tests
        }
    }
}
```
