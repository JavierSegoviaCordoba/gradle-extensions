package com.javiersc.gradle.extensions

import com.javiersc.kotlin.stdlib.AnsiColor
import com.javiersc.kotlin.stdlib.ansiColor
import org.gradle.api.logging.Logger

fun Logger.lifecycleColored(color: AnsiColor = AnsiColor.Reset, message: () -> String) {
    lifecycle(message().ansiColor(color))
}

fun Logger.traceColored(color: AnsiColor = AnsiColor.Foreground.Purple, message: () -> String) {
    trace(message().ansiColor(color))
}

fun Logger.debugColored(color: AnsiColor = AnsiColor.Foreground.Cyan, message: () -> String) {
    debug(message().ansiColor(color))
}

fun Logger.infoColored(color: AnsiColor = AnsiColor.Foreground.Blue, message: () -> String) {
    info(message().ansiColor(color))
}

fun Logger.warnColored(color: AnsiColor = AnsiColor.Foreground.Yellow, message: () -> String) {
    warn(message().ansiColor(color))
}

fun Logger.errorColored(message: String, color: AnsiColor = AnsiColor.Foreground.Red) {
    warn(message.ansiColor(color))
}
