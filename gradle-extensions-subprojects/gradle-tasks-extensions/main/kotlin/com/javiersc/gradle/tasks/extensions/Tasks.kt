package com.javiersc.gradle.tasks.extensions

import org.gradle.api.Action
import org.gradle.api.Task
import org.gradle.api.tasks.TaskCollection
import org.gradle.api.tasks.TaskContainer
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

public inline fun <reified T : Task> TaskContainer.namedLazily(
    name: String,
    action: Action<in T>? = null,
): TaskCollection<T> {
    val collection: TaskCollection<T> = withType<T>().matching { it.name == name }
    if (action != null) collection.configureEach(action)
    return collection
}

public inline fun <reified T : Task> TaskContainer.maybeRegisterLazily(
    name: String,
    action: Action<in T>? = null,
): TaskCollection<T> =
    if (names.contains(name)) {
        namedLazily(name = name, action = action)
    } else {
        register<T>(name)
        namedLazily(name = name, action = action)
    }
