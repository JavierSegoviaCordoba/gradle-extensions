package com.javiersc.gradle.project.test.extensions

import com.javiersc.gradle.common.test.extensions.GradleCommonTestApi
import java.io.File
import org.gradle.api.Project

public interface GradleProjectTestApi : GradleCommonTestApi {

    public fun gradleProjectTest(
        sandboxPath: String? = null,
        name: String = buildValidPathName(sandboxPath),
        parent: Project? = null,
        gradleUserHomeDir: File? = null,
        test: ProjectTest,
    )
}
