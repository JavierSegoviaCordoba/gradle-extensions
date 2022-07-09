import com.javiersc.gradle.delegated.properties.extensions.delegatedProperty
import com.javiersc.gradle.delegated.properties.extensions.getValue
import com.javiersc.gradle.delegated.properties.extensions.setValue

plugins {
    id("fake.plugin")
}

var property: String by delegatedProperty("DELEGATED 1")

println(property)
property = "DELEGATED 2"
println(property)
