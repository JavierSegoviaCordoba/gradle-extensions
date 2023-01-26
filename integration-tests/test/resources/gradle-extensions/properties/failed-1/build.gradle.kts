import com.javiersc.gradle.properties.extensions.getDoubleProperty

plugins {
    id("fake.plugin")
}

fun printlnProperty(prop: String, action: Project.(String) -> Any?) {
    println("$prop: ${action(prop)}")
}

printlnProperty("prop.double") { getDoubleProperty(it) }
printlnProperty("local.prop.double") { getDoubleProperty(it) }
