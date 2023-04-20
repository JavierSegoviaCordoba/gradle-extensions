import com.javiersc.gradle.properties.extensions.getBooleanProperty
import com.javiersc.gradle.properties.extensions.getDoubleProperty
import com.javiersc.gradle.properties.extensions.getIntProperty
import com.javiersc.gradle.properties.extensions.getLongProperty
import com.javiersc.gradle.properties.extensions.getStringProperty

plugins {
    id("fake.plugin")
}

fun <T> printlnProperty(prop: String, action: Project.(String) -> Provider<T>) {
    println("$prop: ${action(prop).orNull}")
}

printlnProperty("env.prop.boolean") { getBooleanProperty(it) }
printlnProperty("env.prop.boolean2") { getBooleanProperty(it) }
printlnProperty("ENV_PROP_BOOLEAN") { getBooleanProperty(it) }
printlnProperty("ENV_PROP_BOOLEAN2") { getBooleanProperty(it) }
printlnProperty("env.prop.double") { getDoubleProperty(it) }
printlnProperty("env.prop.double2") { getDoubleProperty(it) }
printlnProperty("ENV_PROP_DOUBLE") { getDoubleProperty(it) }
printlnProperty("ENV_PROP_DOUBLE2") { getDoubleProperty(it) }
printlnProperty("env.prop.int") { getIntProperty(it) }
printlnProperty("env.prop.int2") { getIntProperty(it) }
printlnProperty("ENV_PROP_INT") { getIntProperty(it) }
printlnProperty("ENV_PROP_INT2") { getIntProperty(it) }
printlnProperty("env.prop.long") { getLongProperty(it) }
printlnProperty("env.prop.long2") { getLongProperty(it) }
printlnProperty("ENV_PROP_LONG") { getLongProperty(it) }
printlnProperty("ENV_PROP_LONG2") { getLongProperty(it) }
printlnProperty("env.prop.string") { getStringProperty(it) }
printlnProperty("env.prop.string2") { getStringProperty(it) }
printlnProperty("ENV_PROP_STRING") { getStringProperty(it) }
printlnProperty("ENV_PROP_STRING2") { getStringProperty(it) }

printlnProperty("gradle.local.prop.boolean") { getBooleanProperty(it) }
printlnProperty("gradle.local.prop.boolean2") { getBooleanProperty(it) }
printlnProperty("gradle.local.prop.double") { getDoubleProperty(it) }
printlnProperty("gradle.local.prop.double2") { getDoubleProperty(it) }
printlnProperty("gradle.local.prop.int") { getIntProperty(it) }
printlnProperty("gradle.local.prop.int2") { getIntProperty(it) }
printlnProperty("gradle.local.prop.long") { getLongProperty(it) }
printlnProperty("gradle.local.prop.long2") { getLongProperty(it) }
printlnProperty("gradle.local.prop.string") { getStringProperty(it) }
printlnProperty("gradle.local.prop.string2") { getStringProperty(it) }

printlnProperty("local.prop.boolean") { getBooleanProperty(it) }
printlnProperty("local.prop.boolean2") { getBooleanProperty(it) }
printlnProperty("local.prop.double") { getDoubleProperty(it) }
printlnProperty("local.prop.double2") { getDoubleProperty(it) }
printlnProperty("local.prop.int") { getIntProperty(it) }
printlnProperty("local.prop.int2") { getIntProperty(it) }
printlnProperty("local.prop.long") { getLongProperty(it) }
printlnProperty("local.prop.long2") { getLongProperty(it) }
printlnProperty("local.prop.string") { getStringProperty(it) }
printlnProperty("local.prop.string2") { getStringProperty(it) }

printlnProperty("prop.boolean") { getBooleanProperty(it) }
printlnProperty("prop.boolean2") { getBooleanProperty(it) }
printlnProperty("prop.double") { getDoubleProperty(it) }
printlnProperty("prop.double2") { getDoubleProperty(it) }
printlnProperty("prop.int") { getIntProperty(it) }
printlnProperty("prop.int2") { getIntProperty(it) }
printlnProperty("prop.long") { getLongProperty(it) }
printlnProperty("prop.long2") { getLongProperty(it) }
printlnProperty("prop.string") { getStringProperty(it) }
printlnProperty("prop.string2") { getStringProperty(it) }

printlnProperty("cli.prop.priority") { getStringProperty(it) }
printlnProperty("environment.prop.priority") { getStringProperty(it) }
printlnProperty("local.prop.priority") { getStringProperty(it) }
printlnProperty("gradle.local.prop.priority") { getStringProperty(it) }
printlnProperty("prop.priority") { getStringProperty(it) }
