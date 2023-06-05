package com.andreolas.template.initializers

import android.content.Context
import androidx.startup.Initializer
import com.andreolas.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

  override fun create(context: Context) {
    if (BuildConfig.DEBUG) { // todo fixme
      Timber.plant(Timber.DebugTree())
    }
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
