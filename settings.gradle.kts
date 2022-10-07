pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("tests") {
            from(files("gradle/tests.versions.toml"))
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "ApiSampleDevPass"
include(":app")
include(":infra:network:public")
include(":infra:network:impl")
include(":infra:states")
include(":infra:api")
include(":domain")
include(":feature:repo-list:public")
include(":feature:repo-list:impl")
