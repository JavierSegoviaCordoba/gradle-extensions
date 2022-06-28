# Module gradle-properties-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-properties-extensions:$version")
}
```

### Usage

```kotlin
project.localProperties // `Properties?` closest to the project

/**
 * Get a property in the next order of priority from
 *   - local.properties (closest to the project has priority)
 *   - Environment variables
 *   - gradle.properties (closest to the project has priority)
 */
project.getProperty("some") // get the property as `String` crash if null
project.getPropertyOrNull("some")
project.getBooleanProperty("some") // get the property as `Boolean`
project.getDoubleProperty("some") // get the property as `Double`, crash if null or not parseable
project.getDoublePropertyOrNull("some") // get the property as `Double?`
project.getIntProperty("some") // get the property as `Int`, crash if null or not parseable
project.getIntPropertyOrNull("some") // get the property as `Int?`
project.getLongProperty("some") // get the property as `Long`, crash if null or not parseable
project.getLongPropertyOrNull("some") // get the property as `Long?`
project.getStringProperty("some") // get the property as `String`, crash if null or not parseable
project.getStringPropertyOrNull("some") // get the property as `String?`
```
