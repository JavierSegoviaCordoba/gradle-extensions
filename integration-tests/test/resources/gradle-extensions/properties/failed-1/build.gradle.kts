import com.javiersc.gradle.properties.extensions.getStringProperty
import com.javiersc.gradle.properties.extensions.getStringPropertyOrNull
import com.javiersc.gradle.properties.extensions.getBooleanProperty
import com.javiersc.gradle.properties.extensions.getDoubleProperty
import com.javiersc.gradle.properties.extensions.getDoublePropertyOrNull
import com.javiersc.gradle.properties.extensions.getIntProperty
import com.javiersc.gradle.properties.extensions.getIntPropertyOrNull
import com.javiersc.gradle.properties.extensions.getLongProperty
import com.javiersc.gradle.properties.extensions.getLongPropertyOrNull

plugins {
    id("fake.plugin")
}

fun printlnProperty(prop: String, action: Project.(String) -> Any?) {
    println("$prop: ${action(prop)}")
}

printlnProperty("prop.double") { getDoubleProperty(it) }
printlnProperty("local.prop.double") { getDoubleProperty(it) }
