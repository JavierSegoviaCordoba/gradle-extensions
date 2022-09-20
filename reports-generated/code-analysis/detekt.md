# detekt

## Metrics

* 73 number of properties

* 86 number of functions

* 10 number of classes

* 13 number of packages

* 35 number of kt files

## Complexity Report

* 1,195 lines of code (loc)

* 988 source lines of code (sloc)

* 700 logical lines of code (lloc)

* 1 comment lines of code (cloc)

* 139 cyclomatic complexity (mcc)

* 24 cognitive complexity

* 20 number of total code smells

* 0% comment source ratio

* 198 mcc per 1,000 lloc

* 28 code smells per 1,000 lloc

## Findings (20)

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:17:33
```
The function gradleTestKitTest(sandboxPath: String?, name: String, withDebug: Boolean, withPluginClasspath: Boolean, isolated: Boolean, test: GradleRunner.() -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
14 
15     @TempDir(cleanup = ON_SUCCESS) private lateinit var isolatedTempDir: File
16 
17     public fun gradleTestKitTest(
!!                                 ^ error
18         sandboxPath: String? = null,
19         name: String = sandboxPath?.sanitizedSandboxPathPrefix() ?: "",
20         withDebug: Boolean = false,

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

### style, FunctionOnlyReturningConstant (8)

A function that only returns a constant is misleading. Consider declaring a constant instead.

[Documentation](https://detekt.dev/docs/rules/style#functiononlyreturningconstant)

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:135:16
```
info is returning a constant. Prefer declaring a constant instead.
```
```kotlin
132         withArguments(arguments + systemProperty(value))
133     }
134 
135     public fun info(): String = "--info"
!!!                ^ error
136 
137     public fun GradleRunner.andWithInfo() {
138         withArguments(arguments + info())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:141:16
```
stacktrace is returning a constant. Prefer declaring a constant instead.
```
```kotlin
138         withArguments(arguments + info())
139     }
140 
141     public fun stacktrace(): String = "--stacktrace"
!!!                ^ error
142 
143     public fun GradleRunner.andWithStacktrace() {
144         withArguments(arguments + stacktrace())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:147:16
```
scan is returning a constant. Prefer declaring a constant instead.
```
```kotlin
144         withArguments(arguments + stacktrace())
145     }
146 
147     public fun scan(): String = "--scan"
!!!                ^ error
148 
149     public fun GradleRunner.andWithScan() {
150         withArguments(arguments + scan())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:153:16
```
buildCache is returning a constant. Prefer declaring a constant instead.
```
```kotlin
150         withArguments(arguments + scan())
151     }
152 
153     public fun buildCache(): String = "--build-cache"
!!!                ^ error
154 
155     public fun GradleRunner.andWithBuildCache() {
156         withArguments(arguments + buildCache())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:159:16
```
noBuildCache is returning a constant. Prefer declaring a constant instead.
```
```kotlin
156         withArguments(arguments + buildCache())
157     }
158 
159     public fun noBuildCache(): String = "--no-build-cache"
!!!                ^ error
160 
161     public fun GradleRunner.andWithNoBuildCache() {
162         withArguments(arguments + noBuildCache())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:165:16
```
configurationCache is returning a constant. Prefer declaring a constant instead.
```
```kotlin
162         withArguments(arguments + noBuildCache())
163     }
164 
165     public fun configurationCache(): String = "--configuration-cache"
!!!                ^ error
166 
167     public fun GradleRunner.andWithConfigurationCache() {
168         withArguments(arguments + configurationCache())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:171:16
```
noConfigurationCache is returning a constant. Prefer declaring a constant instead.
```
```kotlin
168         withArguments(arguments + configurationCache())
169     }
170 
171     public fun noConfigurationCache(): String = "--no-configuration-cache"
!!!                ^ error
172 
173     public fun GradleRunner.andWithNoConfigurationCache() {
174         withArguments(arguments + noConfigurationCache())

```

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:177:16
```
configurationCacheProblemsWarn is returning a constant. Prefer declaring a constant instead.
```
```kotlin
174         withArguments(arguments + noConfigurationCache())
175     }
176 
177     public fun configurationCacheProblemsWarn(): String = "--configuration-cache-problems=warn"
!!!                ^ error
178 
179     public fun GradleRunner.andWithConfigurationCacheProblemsWarn() {
180         withArguments(arguments + configurationCacheProblemsWarn())

```

### style, UnnecessaryAbstractClass (1)

An abstract class is unnecessary and can be refactored. An abstract class should have both abstract and concrete properties or functions. An abstract class without a concrete member can be refactored to an interface. An abstract class without an abstract member can be refactored to a concrete class.

[Documentation](https://detekt.dev/docs/rules/style#unnecessaryabstractclass)

* gradle-test-extensions-subprojects/gradle-testkit-test-extensions/main/kotlin/com/javiersc/gradle/testkit/test/extensions/GradleTest.kt:11:23
```
An abstract class without an abstract member can be refactored to a concrete class.
```
```kotlin
8  import org.junit.jupiter.api.io.CleanupMode.ON_SUCCESS
9  import org.junit.jupiter.api.io.TempDir
10 
11 public abstract class GradleTest {
!!                       ^ error
12 
13     @TempDir(cleanup = ON_SUCCESS) private lateinit var tempDir: File
14 

```

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-09-20 17:21:06 UTC