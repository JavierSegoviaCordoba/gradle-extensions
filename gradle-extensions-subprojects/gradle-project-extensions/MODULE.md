# Module gradle-project-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-project-extensions:$version")
}
```

### Usage

```kotlin
project.isRootProject // `true` for root, `false` for subprojects
project.module // "${project.group}:${project.name}"
project.library // "${project.group}:${project.name}:${project.version}"
project.isSnapshot // `true` if version ends with `-SNAPSHOT`
project.isNotSnapshot // `true` if version does not ends with `-SNAPSHOT`
```
