package net.imt.fmsbookstore

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class FMSBookStore: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@FMSBookStore)
            modules(
                networkModule, serviceModule, databaseModule, repositoryModule, viewModelModule
            )
        }
    }
}
