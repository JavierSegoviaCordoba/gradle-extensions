package com.javiersc.gradle.miscellanea.extensions

import org.gradle.internal.os.OperatingSystem
import org.gradle.process.ExecOperations

public fun ExecOperations.echo(vararg arg: String) {
    val command: List<String> =
        if (OperatingSystem.current().isWindows) listOf("cmd", "/c", "echo") + arg.toList()
        else listOf("echo") + arg.toList()
    exec { it.commandLine(command) }
}

public inline fun ExecOperations.echo(message: () -> String) {
    echo(message())
}
