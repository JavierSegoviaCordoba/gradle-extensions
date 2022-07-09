# Module gradle-delegated-properties-extensions

### Download from MavenCentral

```kotlin
dependencies {
    implementation("com.javiersc.gradle:gradle-delegated-properties-extensions:$version")
}
```

### Usage

Remember to import `getValue` and `setValue`!!!

```kotlin
import com.javiersc.gradle.delegated.properties.extensions.delegatedProperty
import com.javiersc.gradle.delegated.properties.extensions.getValue
import com.javiersc.gradle.delegated.properties.extensions.setValue

var property1: Int by delegatedProperty()
var property2: Int by project.delegatedProperty()
var property3: Int by objects.delegatedProperty()

var property4: Int by delegatedProperty(initial = 4)
var property5: Int by project.delegatedProperty(initial = 5)
var property6: Int by objects.delegatedProperty(initial = 6)

println(property1) // crash, no value available
println(property2) // crash, no value available
println(property3) // crash, no value available

property1 = 1
property2 = 2
property3 = 3

println(property1) // 1
println(property2) // 2
println(property3) // 3

println(property6) // 4
println(property6) // 5
println(property6) // 6
```
