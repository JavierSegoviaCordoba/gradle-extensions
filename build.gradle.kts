import com.javiersc.kotlin.stdlib.notContain
import org.sonarqube.gradle.SonarExtension

plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        analysis()
        binaryCompatibilityValidator()
        coverage()
        documentation {
            api()
            changelog()
            readme {
                badges()
            }
            site()
        }
        nexus()
    }
}

project.allprojects {
    afterEvaluate {
        extensions.findByType<SonarExtension>()?.apply {
            properties {
                val kotlinFiles = rootDir.walkTopDown().filter { it.extension == "kt" && it.name.notContain("DelegatedProperties") }.map { it.path }.toList()
                property("sonar.sources", kotlinFiles)
                property("sonar.tests", kotlinFiles)
            }
        }
    }
}
