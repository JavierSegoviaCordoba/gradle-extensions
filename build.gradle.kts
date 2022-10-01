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
            site {
                excludes(projects.integrationTests)
            }
        }
        nexus()
    }
}
