plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-formatter`
    `javiersc-docs`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
    `kotlinx-binary-compatibility-validator`
}

docs {
    navigation {
        reports {
            codeCoverage.set(false)
        }
    }
}

readmeBadges {
    coverage.set(false)
}

removeProjectFromDoc(
    ":gradle-testkit-ext-integration-tests",
)

fun removeProjectFromDoc(vararg paths: String) {
    val projects = mutableListOf<Project>()

    for (path in paths) {
        if (findProject(path) != null) projects.add(project(path))
    }

    tasks { dokkaHtmlMultiModule { removeChildTasks(projects) } }
}
