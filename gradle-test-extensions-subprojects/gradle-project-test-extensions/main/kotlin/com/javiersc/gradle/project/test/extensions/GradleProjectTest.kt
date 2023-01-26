package com.javiersc.gradle.project.test.extensions

import java.io.File
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir

public open class GradleProjectTest : GradleProjectTestApi {

    @TempDir(cleanup = CleanupMode.ON_SUCCESS) private lateinit var projectDir: File

    override fun gradleProjectTest(
        sandboxPath: String?,
        name: String,
        parent: Project?,
        gradleUserHomeDir: File?,
        test: ProjectTest
    ) {
        val projectDir = projectDir.resolve(name).apply(File::mkdirs)

        if (sandboxPath != null) resourceFile(sandboxPath).copyRecursively(projectDir)

        val project: Project =
            ProjectBuilder.builder()
                .withName(name)
                .withParent(parent)
                .withProjectDir(projectDir)
                .withGradleUserHomeDir(gradleUserHomeDir)
                .build()

        test.run { project.execute() }
    }
}

public fun interface ProjectTest {

    public fun Project.execute()
}
