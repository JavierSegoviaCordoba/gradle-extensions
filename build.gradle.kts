import org.jetbrains.dokka.gradle.DokkaMultiModuleTask

buildscript {
    dependencies {
        classpath(libs.jetbrains.kotlin.kotlinGradlePlugin)
    }
}

plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
        binaryCompatibilityValidator()
        coverage()
        documentation {
            changelog()
            readme {
                badges()
            }
            site()
        }
        nexus()
    }
}


removeProjectFromDoc(projects.integrationTests)

fun removeProjectFromDoc(vararg projects: ProjectDependency) {
    tasks.withType<DokkaMultiModuleTask>().configureEach {
        removeChildTasks(projects.map { it.dependencyProject })
    }
}
