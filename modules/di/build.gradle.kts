plugins {
  alias(libs.plugins.com.android.library)
  alias(libs.plugins.kotlin.android)
}

android {
  namespace = "template.di"
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.koin)
}
