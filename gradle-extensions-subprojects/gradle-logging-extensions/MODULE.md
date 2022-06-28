# Module gradle-logging-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-logging-extensions:$version")
}
```

### Usage

```kotlin
project.logger.lifecycleColored { "Some message" }
project.logger.traceColored { "Some message" }
project.logger.debugColored { "Some message" }
project.logger.infoColored { "Some message" }
project.logger.warnColored { "Some message" }
project.logger.errorColored { "Some message" }
```

Any `*Colored` function has a default color parameter which can be changed:

```kotlin
project.logger.lifecycleColored(color = AnsiColor.Foreground.Yellow) { "Some message" }
```
