import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.com.android.library) apply false
  alias(libs.plugins.detekt) version libs.versions.detekt
}
true // Needed to make the Suppress annotation work for the plugins block

subprojects {
  project.plugins.configureAppAndModules(project = project)
  apply(from = buildscripts("detekt.gradle"))
}

fun PluginContainer.configureAppAndModules(project: Project) = apply {
  whenPluginAdded {
    when (this) {
      is AppPlugin -> {
        project.extensions
          .getByType<AppExtension>()
          .apply { applyAppCommons() }
      }
      is LibraryPlugin -> {
        project.extensions
          .getByType<LibraryExtension>()
          .apply { applyLibraryCommons() }
      }
    }
  }
}

fun AppExtension.applyAppCommons() {
  applyBaseCommons()

  defaultConfig.apply {
    // versionName here is static because we don't want to break incremental builds.
    // versionName must be changed ONLY from gradle task, iff buildType is release/demo.
    versionName = Versions.APP_VERSION_NAME
  }
}

fun LibraryExtension.applyLibraryCommons() {
  applyBaseCommons()
}

fun BaseExtension.applyBaseCommons() {
  compileSdkVersion(Versions.COMPILE_SDK_VERSION)

  defaultConfig.apply {
    minSdk = Versions.MIN_SDK_VERSION
    targetSdk = Versions.TARGET_SDK_VERSION
    versionCode = Versions.APP_VERSION_CODE
  }

  compileOptions.apply {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}
