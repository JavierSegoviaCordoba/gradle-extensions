# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

- `gradleBuildCacheTestKitTest` and `gradleConfigurationCacheTestKitTest` task output is null always

### Updated

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
- `andWithConfigurationCache` function
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
