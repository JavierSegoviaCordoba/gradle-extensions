package com.javiersc.gradle.logging.extensions

import com.javiersc.kotlin.stdlib.AnsiColor
import com.javiersc.kotlin.stdlib.AnsiColor.Foreground
import com.javiersc.kotlin.stdlib.AnsiColor.Reset
import com.javiersc.kotlin.stdlib.ansiColor
import org.gradle.api.logging.Logger

public fun Logger.errorColored(color: AnsiColor = Foreground.Red, message: () -> String) {
    error(message().ansiColor(color))
}

public fun Logger.quietColored(color: AnsiColor = Reset, message: () -> String) {
    quiet(message().ansiColor(color))
}

public fun Logger.warnColored(color: AnsiColor = Foreground.Yellow, message: () -> String) {
    warn(message().ansiColor(color))
}

public fun Logger.lifecycleColored(color: AnsiColor = Foreground.Green, message: () -> String) {
    lifecycle(message().ansiColor(color))
}

public fun Logger.infoColored(color: AnsiColor = Foreground.Blue, message: () -> String) {
    info(message().ansiColor(color))
}

public fun Logger.debugColored(color: AnsiColor = Foreground.Cyan, message: () -> String) {
    debug(message().ansiColor(color))
}
