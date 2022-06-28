# Module gradle-tasks-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-tasks-extensions:$version")
}
```

### Usage

```kotlin
project.tasks.namedLazily<TaskType>("taskName").configureEach { 
    // ...
}

project.tasks.maybeRegisterLazily<TaskType>("taskName").configureEach {
    // ...
}
```
