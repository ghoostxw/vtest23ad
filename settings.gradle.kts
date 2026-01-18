pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "V2rayAdGuard"

include(":app")
include(":core")
include(":dns")
include(":shared")
// Временно закомментируй если мешают:
// include(":rust")
// include(":jni")
