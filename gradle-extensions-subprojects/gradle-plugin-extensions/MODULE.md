# Module gradle-plugin-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-plugin-extensions:$version")
}
```

### Usage

```kotlin
class SomeProjectPlugin : Plugin<Project> {

    override fun Project.apply() {
        TODO("Create your project plugin")
    }
}
```

```kotlin
class SomeProjectPlugin : Plugin<Settings> {

    override fun Settings.apply() {
        TODO("Create your settings plugin")
    }
}
```
