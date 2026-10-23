@file:Suppress("UNCHECKED_CAST")

try {
    val peClass = Class.forName("java.lang.ProcessEnvironment")
    val envField = peClass.getDeclaredField("theEnvironment")
    envField.isAccessible = true
    (envField.get(null) as? MutableMap<String, String>)?.remove("ANDROID_PREFS_ROOT")

    val ciEnvField = peClass.getDeclaredField("theCaseInsensitiveEnvironment")
    ciEnvField.isAccessible = true
    (ciEnvField.get(null) as? MutableMap<String, String>)?.remove("ANDROID_PREFS_ROOT")
} catch (_: Exception) {}

rootProject.name = "MediTurnos"

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":androidApp")
include(":shared")