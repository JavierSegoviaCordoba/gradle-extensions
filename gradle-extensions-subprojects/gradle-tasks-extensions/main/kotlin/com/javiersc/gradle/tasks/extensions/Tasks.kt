package com.javiersc.gradle.tasks.extensions

import org.gradle.api.Action
import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.register

@JvmName("maybeNamedTask")
public fun TaskContainer.maybeNamed(
    name: String,
    action: Action<Task> = Action {},
): TaskProvider<Task>? = if (names.contains(name)) named(name).apply { configure(action) } else null

public inline fun <reified T : Task> TaskContainer.maybeNamed(
    name: String,
    action: Action<in T> = Action {},
): TaskProvider<T>? = if (names.contains(name)) named<T>(name).apply { configure(action) } else null

@JvmName("maybeRegisterTask")
public fun TaskContainer.maybeRegister(
    name: String,
    action: Action<Task> = Action {},
): TaskProvider<Task> =
    if (!names.contains(name)) register(name).apply { configure(action) }
    else named(name).apply { configure(action) }

public inline fun <reified T : Task> TaskContainer.maybeRegister(
    name: String,
    action: Action<in T> = Action {},
): TaskProvider<T> =
    if (!names.contains(name)) register<T>(name).apply { configure(action) }
    else named<T>(name).apply { configure(action) }
