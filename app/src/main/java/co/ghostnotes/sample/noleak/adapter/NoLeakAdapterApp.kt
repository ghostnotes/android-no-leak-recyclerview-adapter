package co.ghostnotes.sample.noleak.adapter

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class NoLeakAdapterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}