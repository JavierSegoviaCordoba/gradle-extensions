# Module gradle-version-catalog-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-version-catalog-extensions:$version")
}
```

### Usage

```kotlin
val catalogExtension = project.the<VersionCatalogExtension>()

catalogExtension.getLibrariesByGroup("com.javiersc.gradle")

catalogExtension.getLibraryByModule("com.javiersc.gradle:gradle-extensions") // crash if `null`
catalogExtension.getLibraryByModuleOrNull("com.javiersc.gradle:gradle-extensions")

catalogExtension.getLibraries(catalog = catalogExtension.named("libs"))
catalogExtension.getLibraries(catalogName = "libs")

catalogExtension.catalogNamesWithLibsAtFirst // `libs`, `aLibs`, `zlibs`, ...
```
