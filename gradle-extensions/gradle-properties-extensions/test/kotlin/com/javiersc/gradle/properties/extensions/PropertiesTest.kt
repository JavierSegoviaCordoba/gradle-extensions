package com.javiersc.gradle.properties.extensions

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PropertiesTest {

    @Test
    fun `Property to snake case`() {
        PropertyKey.Project.group.toSnakeCase().shouldBe("PROJECT_GROUP")
        PropertyKey.Project.version.toSnakeCase().shouldBe("PROJECT_VERSION")

        PropertyKey.POM.name.toSnakeCase().shouldBe("POM_NAME")
        PropertyKey.POM.description.toSnakeCase().shouldBe("POM_DESCRIPTION")
        PropertyKey.POM.url.toSnakeCase().shouldBe("POM_URL")
        PropertyKey.POM.licenseName.toSnakeCase().shouldBe("POM_LICENSE_NAME")
        PropertyKey.POM.licenseUrl.toSnakeCase().shouldBe("POM_LICENSE_URL")
        PropertyKey.POM.developerId.toSnakeCase().shouldBe("POM_DEVELOPER_ID")
        PropertyKey.POM.developerName.toSnakeCase().shouldBe("POM_DEVELOPER_NAME")
        PropertyKey.POM.developerEmail.toSnakeCase().shouldBe("POM_DEVELOPER_EMAIL")
        PropertyKey.POM.scmUrl.toSnakeCase().shouldBe("POM_SCM_URL")
        PropertyKey.POM.scmConnection.toSnakeCase().shouldBe("POM_SCM_CONNECTION")
        PropertyKey.POM.scmDeveloperConnection
            .toSnakeCase()
            .shouldBe("POM_SCM_DEVELOPER_CONNECTION")

        PropertyKey.Signing.gnupgKeyname.toSnakeCase().shouldBe("SIGNING_GNUPG_KEY_NAME")
        PropertyKey.Signing.gnupgPassphrase.toSnakeCase().shouldBe("SIGNING_GNUPG_PASSPHRASE")
        PropertyKey.Signing.keyId.toSnakeCase().shouldBe("SIGNING_KEY_ID")
    }
}

internal object PropertyKey {

    internal object POM {
        const val name: String = "pom.name"
        const val description: String = "pom.description"
        const val url: String = "pom.url"
        const val licenseName: String = "pom.license.name"
        const val licenseUrl: String = "pom.license.url"
        const val developerId: String = "pom.developer.id"
        const val developerName: String = "pom.developer.name"
        const val developerEmail: String = "pom.developer.email"
        const val scmUrl: String = "pom.scm.url"
        const val scmConnection: String = "pom.scm.connection"
        const val scmDeveloperConnection: String = "pom.scm.developerConnection"
    }

    internal object Project {
        const val group: String = "project.group"
        const val version: String = "project.version"
    }

    internal object Signing {
        const val gnupgKeyname: String = "signing.gnupg.keyName"
        const val gnupgPassphrase: String = "signing.gnupg.passphrase"
        const val keyId: String = "signing.keyId"
    }
}
