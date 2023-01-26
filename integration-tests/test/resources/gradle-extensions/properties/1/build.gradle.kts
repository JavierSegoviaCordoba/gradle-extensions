import com.javiersc.gradle.properties.extensions.getBooleanProperty
import com.javiersc.gradle.properties.extensions.getDoubleProperty
import com.javiersc.gradle.properties.extensions.getDoublePropertyOrNull
import com.javiersc.gradle.properties.extensions.getIntProperty
import com.javiersc.gradle.properties.extensions.getIntPropertyOrNull
import com.javiersc.gradle.properties.extensions.getLongProperty
import com.javiersc.gradle.properties.extensions.getLongPropertyOrNull
import com.javiersc.gradle.properties.extensions.getStringProperty
import com.javiersc.gradle.properties.extensions.getStringPropertyOrNull

plugins {
    id("fake.plugin")
}

fun printlnProperty(prop: String, action: Project.(String) -> Any?) {
    println("$prop: ${action(prop)}")
}

printlnProperty("prop.boolean", Project::getBooleanProperty)
printlnProperty("prop.boolean2", Project::getBooleanProperty)
printlnProperty("local.prop.boolean", Project::getBooleanProperty)
printlnProperty("local.prop.boolean2", Project::getBooleanProperty)

printlnProperty("prop.double") { getDoubleProperty(it) }
printlnProperty("prop.double2") { getDoublePropertyOrNull(it) }
printlnProperty("local.prop.double") { getDoubleProperty(it) }
printlnProperty("local.prop.double2") { getDoublePropertyOrNull(it) }

printlnProperty("prop.int") { getIntProperty(it) }
printlnProperty("prop.int2") { getIntPropertyOrNull(it) }
printlnProperty("local.prop.int") { getIntProperty(it) }
printlnProperty("local.prop.int2") { getIntPropertyOrNull(it) }

printlnProperty("prop.long") { getLongProperty(it) }
printlnProperty("prop.long2") { getLongPropertyOrNull(it) }
printlnProperty("local.prop.long") { getLongProperty(it) }
printlnProperty("local.prop.long2") { getLongPropertyOrNull(it) }

printlnProperty("prop.string") { getStringProperty(it) }
printlnProperty("prop.string2") { getStringPropertyOrNull(it) }
printlnProperty("local.prop.string") { getStringProperty(it) }
printlnProperty("local.prop.string2") { getStringPropertyOrNull(it) }
