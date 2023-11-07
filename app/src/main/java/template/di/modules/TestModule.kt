package template.di.modules

import template.di.DepsQualifiers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val diModules = module {

  single(DepsQualifiers.androidContext) {
    androidContext()
  }

  factory(DepsQualifiers.NOW_LONG) {
    System.currentTimeMillis()
  }
}
