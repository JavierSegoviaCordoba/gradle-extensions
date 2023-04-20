package com.javiersc.gradle.properties.extensions

import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging

internal val defaultLogger: Logger = Logging.getLogger("Gradle Property Extensions")

internal fun propertyNotFound(name: String, source: String) {
    defaultLogger.debug("Property $name found in `$source`")
}
