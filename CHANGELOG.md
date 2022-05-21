# Changelog

## [Unreleased]

### Added

- `invalidate` function to `gradleBuildCacheTestKitTest`

### Changed

### Deprecated

### Removed

- `GradleRunner` receiver from `gradleConfigurationCacheTestKitTest` function
- `GradleRunner` receiver from `gradleBuildCacheTestKitTest` function

### Fixed

### Updated

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
