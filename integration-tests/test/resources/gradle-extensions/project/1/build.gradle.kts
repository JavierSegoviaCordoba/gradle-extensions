import com.javiersc.gradle.project.extensions.isNotSnapshot
import com.javiersc.gradle.project.extensions.isRootProject
import com.javiersc.gradle.project.extensions.isSnapshot
import com.javiersc.gradle.project.extensions.library
import com.javiersc.gradle.project.extensions.module

plugins { id("fake.plugin") }

group = "com.javiersc.fake"

version = "1.0.0"

println("root - isRootProject: $isRootProject")

println("root - module: $module")

println("root - library: $library")

println("root(${project.version}) - isSnapshot: ${isSnapshot.get()}")

println("root(${project.version}) - isSnapshot: ${isNotSnapshot.get()}")

version = "1.0.0-SNAPSHOT"

println("root(${project.version}) - isSnapshot: ${isSnapshot.get()}")

println("root(${project.version}) - isSnapshot: ${isNotSnapshot.get()}")
