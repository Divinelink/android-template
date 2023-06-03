@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.com.android.library)
  alias(libs.plugins.kotlin.android)
}

android {
  namespace = "com.andreolas.resources"

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.extesion.toString()
  }
}

dependencies {
  implementation(platform(libs.compose.bom))
  implementation(libs.activity.compose)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.graphics)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.compose.ui.foundation)
  implementation(libs.compose.material3)

  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.graphics)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.compose.material3)

  testImplementation(libs.junit)

  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.compose.ui.test.junit4)
  debugImplementation(libs.compose.ui.tooling)
  debugImplementation(libs.compose.ui.test.manifest)

}