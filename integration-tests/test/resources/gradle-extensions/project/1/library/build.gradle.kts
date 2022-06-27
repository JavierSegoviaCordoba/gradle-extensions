import com.javiersc.gradle.project.extensions.isRootProject

plugins {
    id("fake.plugin")
}

println("${project.name} - isRootProject: $isRootProject")
