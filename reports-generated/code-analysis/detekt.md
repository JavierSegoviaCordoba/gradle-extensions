# detekt

## Metrics

* 85 number of properties

* 98 number of functions

* 17 number of classes

* 15 number of packages

* 43 number of kt files

## Complexity Report

* 1,423 lines of code (loc)

* 1,169 source lines of code (sloc)

* 813 logical lines of code (lloc)

* 1 comment lines of code (cloc)

* 155 cyclomatic complexity (mcc)

* 30 cognitive complexity

* 11 number of total code smells

* 0% comment source ratio

* 190 mcc per 1,000 lloc

* 13 code smells per 1,000 lloc

## Findings (11)

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTestKitTestApi.kt:11:33
```
The function gradleTestKitTest(sandboxPath: String?, name: String, debug: Boolean, pluginClasspath: Boolean, isolated: Boolean, test: TestKitTest) has too many parameters. The current threshold is set to 6.
```
```kotlin
8  
9  public interface GradleTestKitTestApi : GradleCommonTestApi {
10 
11     public fun gradleTestKitTest(
!!                                 ^ error
12         sandboxPath: String? = null,
13         name: String = buildValidPathName(sandboxPath),
14         debug: Boolean = false,

```

### complexity, TooManyFunctions (2)

Too many functions inside a/an file/class/object/interface always indicate a violation of the single responsibility principle. Maybe the file/class/object/interface wants to manage too many things at once. Extract functionality which clearly belongs together.

[Documentation](https://detekt.dev/docs/rules/complexity#toomanyfunctions)

* gradle-extensions-subprojects/gradle-properties-extensions/main/kotlin/com/javiersc/gradle/properties/extensions/ProjectProperties.kt:1:1
```
File '/home/runner/work/gradle-extensions/gradle-extensions/gradle-extensions-subprojects/gradle-properties-extensions/main/kotlin/com/javiersc/gradle/properties/extensions/ProjectProperties.kt' with '13' functions detected. Defined threshold inside files is set to '11'
```
```kotlin
1 package com.javiersc.gradle.properties.extensions
! ^ error
2 
3 import java.io.File
4 import org.gradle.api.Project

```

* gradle-extensions-subprojects/gradle-properties-extensions/main/kotlin/com/javiersc/gradle/properties/extensions/SettingsProperties.kt:1:1
```
File '/home/runner/work/gradle-extensions/gradle-extensions/gradle-extensions-subprojects/gradle-properties-extensions/main/kotlin/com/javiersc/gradle/properties/extensions/SettingsProperties.kt' with '11' functions detected. Defined threshold inside files is set to '11'
```
```kotlin
1 package com.javiersc.gradle.properties.extensions
! ^ error
2 
3 import java.io.File
4 import org.gradle.api.initialization.Settings

```

### exceptions, InstanceOfCheckForException (3)

Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.

[Documentation](https://detekt.dev/docs/rules/exceptions#instanceofcheckforexception)

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:19:17
```
Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.
```
```kotlin
16             method(provider) as Provider<S>
17         } catch (e: Exception) {
18             val shouldThrowRuntimeException =
19                 e is NoSuchMethodException ||
!!                 ^ error
20                     e is IllegalAccessException ||
21                     e is InvocationTargetException
22             if (shouldThrowRuntimeException) {

```

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:20:21
```
Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.
```
```kotlin
17         } catch (e: Exception) {
18             val shouldThrowRuntimeException =
19                 e is NoSuchMethodException ||
20                     e is IllegalAccessException ||
!!                     ^ error
21                     e is InvocationTargetException
22             if (shouldThrowRuntimeException) {
23                 throw RuntimeException("Could not mark provider usage for configuration time.", e)

```

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:21:21
```
Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.
```
```kotlin
18             val shouldThrowRuntimeException =
19                 e is NoSuchMethodException ||
20                     e is IllegalAccessException ||
21                     e is InvocationTargetException
!!                     ^ error
22             if (shouldThrowRuntimeException) {
23                 throw RuntimeException("Could not mark provider usage for configuration time.", e)
24             } else {

```

### exceptions, TooGenericExceptionCaught (1)

The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:17:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
14         try {
15             val method: Method = Provider::class.java.getMethod("forUseAtConfigurationTime")
16             method(provider) as Provider<S>
17         } catch (e: Exception) {
!!                  ^ error
18             val shouldThrowRuntimeException =
19                 e is NoSuchMethodException ||
20                     e is IllegalAccessException ||

```

### exceptions, TooGenericExceptionThrown (1)

The thrown exception is too generic. Prefer throwing project specific exceptions to handle error cases.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptionthrown)

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:23:17
```
RuntimeException is a too generic Exception. Prefer throwing specific exceptions that indicate a specific error case.
```
```kotlin
20                     e is IllegalAccessException ||
21                     e is InvocationTargetException
22             if (shouldThrowRuntimeException) {
23                 throw RuntimeException("Could not mark provider usage for configuration time.", e)
!!                 ^ error
24             } else {
25                 throw e
26             }

```

### naming, MatchingDeclarationName (1)

If a source file contains only a single non-private top-level class or object, the file name should reflect the case-sensitive name plus the .kt extension.

[Documentation](https://detekt.dev/docs/rules/naming#matchingdeclarationname)

* gradle-extensions-subprojects/gradle-delegated-properties-extensions/main/kotlin/com/javiersc/gradle/delegated/properties/extensions/DelegatedProperties.kt:8:23
```
The file name 'DelegatedProperties' does not match the name of the single top-level declaration 'DelegatedProperty'.
```
```kotlin
5  import org.gradle.api.model.ObjectFactory
6  import org.gradle.api.provider.Property
7  
8  public abstract class DelegatedProperty<T> {
!                        ^ error
9  
10     internal abstract val property: Property<T>
11 }

```

### naming, PackageNaming (1)

Package names should match the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#packagenaming)

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/_internal/argumentsTxt.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.gradle.testkit.test.extensions._internal
! ^ error
2 
3 import org.gradle.testkit.runner.GradleRunner
4 

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* gradle-extensions-subprojects/gradle-miscellanea-extensions/main/kotlin/com/javiersc/gradle/miscellanea/extensions/ForUseAtConfigurationTime.kt:11:1
```
This comment contains 'TODO:' that has been defined as forbidden in detekt.
```
```kotlin
8  import org.gradle.util.GradleVersion.current
9  import org.gradle.util.GradleVersion.version
10 
11 // TODO: Remove it when Gradle 7.0 adoption is very high
!! ^ error
12 public fun <S> forUseAtConfigurationTime(provider: Provider<S>): Provider<S> {
13     return if (current() >= version("6.5") && current() < version("7.0")) {
14         try {

```

generated with [detekt version 1.22.0](https://detekt.dev/) on 2023-01-26 13:18:11 UTC
