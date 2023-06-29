# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.39`

## [1.0.0-alpha.32] - 2023-05-18

### Added

- `withPlugins` function
- `PluginDependency.artifact: String` function
- `Provider<PluginDependency>.artifact: Provider<String>`
- `PluginDependency.module: String`
- `Provider<PluginDependency>.module: Provider<String>`

### Updated

- `gradle -> 8.1.1`
- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.16`

## [1.0.0-alpha.31] - 2023-04-28

### Added

- `Settings.objects: ObjectFactory`
- `provider` for settings
- `directoryProvider` for settings
- `directoryProperty` for settings
- `regularFileProvider` for settings
- `fileProperty` for settings
- `regularFileProperty` for settings
- `operator fun Project.invoke(action: Project.() -> Unit)`

### Changed

- all `getProperty` functions

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.12`
- `gradle -> 8.1`

## [1.0.0-alpha.30] - 2023-03-05

### Changed

- `Logging` functions and colors

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.4.0-alpha.16`
- `gradle -> 8.0.2`

## [1.0.0-alpha.29] - 2023-01-26

### Added

- `gradle-project-test-extensions` to do integration tests

### Changed

- `gradle-testkit-test-extensions` only for functional tests

## [1.0.0-alpha.28] - 2023-01-26

### Added

- `GradleTest.gradleTest` for integration tests without TestKit
- `Project.isAlpha: Provider<Boolean>` extension
- `Project.isNotAlpha: Provider<Boolean>` extension
- `Project.isBeta: Provider<Boolean>` extension
- `Project.isNotBeta: Provider<Boolean>` extension
- `Project.isDev: Provider<Boolean>` extension
- `Project.isNotDev: Provider<Boolean>` extension
- `Project.isRC: Provider<Boolean>` extension
- `Project.isNotRC: Provider<Boolean>` extension
- `Project.isSnapshot: Provider<Boolean>` extension
- `Project.isNotSnapshot: Provider<Boolean>` extension
- `Project.property(crossinline block: Project.() -> T): Property<T>` extension
- `Project.listProperty(crossinline block: Project.() -> List<T>): ListProperty<T>` extension
- `Project.setProperty(crossinline block: Project.() -> Set<T>): SetProperty<T>` extension

### Changed

- `GradleTest.gradleTestKitTest` parameters to `debug` and `pluginClasspath`

### Updated

- `com.javiersc.semver:semver-core -> 0.1.0-beta.13`
- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.46`
- `gradle -> 7.6`

## [1.0.0-alpha.27] - 2022-09-13

### Added

- plugin extension artifact which add `interface Plugin<T : Any>` to write Gradle plugins in a Kotlin way
- `Project.getBooleanPropertyOrNull` function
- `DelegatedProperty` and multiple `delegatedProperty` functions

### Updated

- `gradle -> 7.5.1`
- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.29`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.7.10`

## [1.0.0-alpha.26] - 2022-07-05

### Added

- `GradleTest` abstract class which contains Gradle TestKit utils

### Removed

- `GradleRunner` functions (moved to `GradleTest`)

## [1.0.0-alpha.25] - 2022-07-04

### Added

- debug message to `getProperty` functions

## [1.0.0-alpha.24] - 2022-07-03

### Added

- all property functions for `Settings`

## [1.0.0-alpha.23] - 2022-07-03

### Added

- `Provider<PluginDependency>.pluginLibrary: Provider<String>` function
- `Settings.localProperties: Properties?` function
- `gradlewArgumentFromTXT` accepts additional arguments

## [1.0.0-alpha.22] - 2022-06-29

### Added

- `BuildResult.outputTrimmed: String` function

### Fixed

- Gradle TestKit test can't convert a file to be absolute file

## [1.0.0-alpha.21] - 2022-06-28

- No changes

## [1.0.0-alpha.20] - 2022-06-28

### Changed

- all projects `sourceCompatibility` to `1.8`
- all projects `targetCompatibility` to `1.8`
- all projects `jvmTarget` to `1.8`

## [1.0.0-alpha.19] - 2022-06-27

### Added

- Gradle Extensions artifact: `com.javiersc.gradle:gradle-logging-extensions`
- Gradle Extensions artifact: `com.javiersc.gradle:gradle-miscellanea-extensions`
- Gradle Extensions artifact: `com.javiersc.gradle:gradle-project-extensions`
- Gradle Extensions artifact: `com.javiersc.gradle:gradle-properties-extensions`
- Gradle Extensions artifact: `com.javiersc.gradle:gradle-tasks-extensions`
- Gradle Extensions artifact: `com.javiersc.gradle:gradle-version-catalog-extensions`
- Gradle Test Extensions artifact: `com.javiersc.gradle:gradle-testkit-test-extensions`

### Changed

- Gradle Extensions artifact: `com.javiersc.gradle:gradle-extensions`
- Gradle Test Extensions artifact: `com.javiersc.gradle:gradle-test-extensions`

## [1.0.0-alpha.18] - 2022-06-26

### Added

- `Project.isSnapshot: Boolean`
- `Project.isNotSnapshot: Boolean`
- `Project.getProperty(name: String): String`
- `Project.getPropertyOrNull(name: String): String?`
- `Project.getStringProperty(name: String): String`
- `Project.getStringPropertyOrNull(name: String): String?`
- `Project.getIntProperty(name: String): Int`
- `Project.getIntPropertyOrNull(name: String): Int?`
- `Project.getLongProperty(name: String): Long`
- `Project.getLongPropertyOrNull(name: String): Long?`
- `Project.getBooleanProperty(name: String): Boolean`

## [1.0.0-alpha.17] - 2022-06-25

### Added

- `expectTaskOutcome: TaskOutcome` parameter to `GradleRunner.testConfigurationCache`

## [1.0.0-alpha.16] - 2022-06-25

### Changed

- `GradlewRunner.gradlewArgumentsFromTXT` function return type to `BuildResult`

## [1.0.0-alpha.15] - 2022-06-25

### Added

- `Project.module` getter
- `Project.library` getter
- `GradlewRunner.gradlewArgumentsFromTXT` function

## [1.0.0-alpha.14] - 2022-06-23

### Changed

- `gradlew` and `clean` return type from `Unit` to `BuildResult`

### Updated

- `io.kotest:kotest-assertions-core -> 5.3.1`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.10.1`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.3`

## [1.0.0-alpha.13] - 2022-06-14

### Added

- `GradleRunner.gradlew` function
- value argument to set the resulting task to `testBuildCache` and `testConfigurationCache`

## [1.0.0-alpha.12] - 2022-06-14

### Changed

- `gradleBuildCacheTestKitTest` is now `GradleRunner.testBuildCache`
- `gradleConfigurationCacheTestKitTest` is now `GradleRunner.testConfigurationCache`

### Removed

- `withArgumentsFromTXT` value argument from `gradleTestKitTest`

## [1.0.0-alpha.11] - 2022-06-14

### Fixed

- `gradleBuildCacheTestKitTest` and `gradleConfigurationCacheTestKitTest` task output is null always

## [1.0.0-alpha.10] - 2022-06-14

### Fixed

- invalid characters in `prefix` by replacing them with `--`
- unnecessary hyphen when `prefix` is blank in sandbox directories

## [1.0.0-alpha.9] - 2022-06-14

### Updated

- `com.javiersc.kotlin:kotlin-stdlib -> 0.1.0-alpha.5`

## [1.0.0-alpha.8] - 2022-06-14

### Added

- `TaskContainer.namedLazily` function
- `TaskContainer.maybeRegisterLazily` function
- `forUseAtConfigurationTime` function
- `GradleRunner.andWithProjectProperty` function
- `GradleRunner.andWithSystemProperty` function

## [1.0.0-alpha.7] - 2022-06-02

### Added

- `Project.isRootProject: Boolean` property

## [1.0.0-alpha.6] - 2022-05-22

### Fixed

- Invalidated `gradleBuildCacheTestKitTest` is not SUCCESS

## [1.0.0-alpha.5] - 2022-05-21

### Added

- `invalidate` function to `gradleBuildCacheTestKitTest`

### Removed

- `GradleRunner` receiver from `gradleConfigurationCacheTestKitTest` function
- `GradleRunner` receiver from `gradleBuildCacheTestKitTest` function

## [1.0.0-alpha.4] - 2022-05-21

### Added

- `GradleRunner.gradleConfigurationCacheTestKitTest` function
- `GradleRunner.gradleBuildCacheTestKitTest` function

## [1.0.0-alpha.3] - 2022-05-21

### Added

- `GradleRunner.clean` function which launch `clean` task

### Fixed

- `cleanBuildDirectory` function doesn't delete any subproject `build` directory

## [1.0.0-alpha.2] - 2022-05-21

### Added

- `andWithScan` function
- `andWithConfigurationCache` function
- `andWithNoBuildCache` function
- `andWithNoConfigurationCache` function
- `andWithConfigurationCacheProblemsWarn` function
- `withArgumentsFromTXT` function
- `scan` and `addWithScan` functions
- `info` and `addWithInfo` functions
- `stacktrace` and `addWithStacktrace` functions
- `buildCache` and `addWithBuildCache` functions
- `noBuildCache`and `addWithNoBuildCache` functions
- `configurationCache` and `andWithConfigurationCache` functions
- `noConfigurationCache` and `andWithNoConfigurationCache` functions
- `configurationCacheProblemsWarn` and `andWithConfigurationCacheProblemsWarn` functions

### Changed

- all `with...` functions to `andWith...`
- `gradleTestKitTest` function uses `withArgumentsFromTXT` flag instead of list of arguments

## [1.0.0-alpha.1] - 2022-05-21

### Added

- `gradle-ext` project
- `gradle-testkit-ext` project

[Unreleased]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.32...HEAD

[1.0.0-alpha.32]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.31...1.0.0-alpha.32

[1.0.0-alpha.31]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.30...1.0.0-alpha.31

[1.0.0-alpha.30]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.29...1.0.0-alpha.30

[1.0.0-alpha.29]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.28...1.0.0-alpha.29

[1.0.0-alpha.28]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.27...1.0.0-alpha.28

[1.0.0-alpha.27]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.26...1.0.0-alpha.27

[1.0.0-alpha.26]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.25...1.0.0-alpha.26

[1.0.0-alpha.25]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.24...1.0.0-alpha.25

[1.0.0-alpha.24]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.23...1.0.0-alpha.24

[1.0.0-alpha.23]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.22...1.0.0-alpha.23

[1.0.0-alpha.22]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.21...1.0.0-alpha.22

[1.0.0-alpha.21]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.20...1.0.0-alpha.21

[1.0.0-alpha.20]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.19...1.0.0-alpha.20

[1.0.0-alpha.19]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.18...1.0.0-alpha.19

[1.0.0-alpha.18]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.17...1.0.0-alpha.18

[1.0.0-alpha.17]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.16...1.0.0-alpha.17

[1.0.0-alpha.16]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.15...1.0.0-alpha.16

[1.0.0-alpha.15]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.14...1.0.0-alpha.15

[1.0.0-alpha.14]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.13...1.0.0-alpha.14

[1.0.0-alpha.13]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.12...1.0.0-alpha.13

[1.0.0-alpha.12]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.11...1.0.0-alpha.12

[1.0.0-alpha.11]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.10...1.0.0-alpha.11

[1.0.0-alpha.10]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.9...1.0.0-alpha.10

[1.0.0-alpha.9]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.8...1.0.0-alpha.9

[1.0.0-alpha.8]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.7...1.0.0-alpha.8

[1.0.0-alpha.7]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.6...1.0.0-alpha.7

[1.0.0-alpha.6]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.5...1.0.0-alpha.6

[1.0.0-alpha.5]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.4...1.0.0-alpha.5

[1.0.0-alpha.4]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.3...1.0.0-alpha.4

[1.0.0-alpha.3]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.2...1.0.0-alpha.3

[1.0.0-alpha.2]: https://github.com/JavierSegoviaCordoba/gradle-extensions/compare/1.0.0-alpha.1...1.0.0-alpha.2

[1.0.0-alpha.1]: https://github.com/JavierSegoviaCordoba/gradle-extensions/commits/1.0.0-alpha.1
