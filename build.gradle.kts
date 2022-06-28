plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-coverage`
    `javiersc-code-formatter`
    `javiersc-docs`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
    `kotlinx-binary-compatibility-validator`
}

docs { navigation { reports { codeCoverage.set(true) } } }

readmeBadges { coverage.set(true) }

removeProjectFromDoc(projects.integrationTests)

fun removeProjectFromDoc(vararg projects: ProjectDependency) {
    tasks { dokkaHtmlMultiModule { removeChildTasks(projects.map { it.dependencyProject }) } }
}
