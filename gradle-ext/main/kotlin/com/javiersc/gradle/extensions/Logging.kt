package com.javiersc.gradle.extensions

import com.javiersc.kotlin.stdlib.AnsiColor
import com.javiersc.kotlin.stdlib.AnsiColor.Foreground
import com.javiersc.kotlin.stdlib.AnsiColor.Reset
import com.javiersc.kotlin.stdlib.ansiColor
import org.gradle.api.logging.Logger

public fun Logger.lifecycleColored(color: AnsiColor = Reset, message: () -> String) {
    lifecycle(message().ansiColor(color))
}

public fun Logger.traceColored(color: AnsiColor = Foreground.Purple, message: () -> String) {
    trace(message().ansiColor(color))
}

public fun Logger.debugColored(color: AnsiColor = Foreground.Cyan, message: () -> String) {
    debug(message().ansiColor(color))
}

public fun Logger.infoColored(color: AnsiColor = Foreground.Blue, message: () -> String) {
    info(message().ansiColor(color))
}

public fun Logger.warnColored(color: AnsiColor = Foreground.Yellow, message: () -> String) {
    warn(message().ansiColor(color))
}

public fun Logger.errorColored(message: String, color: AnsiColor = Foreground.Red) {
    warn(message.ansiColor(color))
}
