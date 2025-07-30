pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "ContactBook"
include(":app")
include(":component:theme")
include(":component:ui")
include(":shared:contact")
include(":shared:contactdatabase")
include(":shared:useractions")
include(":feature:contactlist")
include(":feature:contactinfo")
include(":util:date")