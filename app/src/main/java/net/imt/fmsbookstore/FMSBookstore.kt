package net.imt.fmsbookstore

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class FMSBookstore: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@FMSBookstore)
            modules(
                networkModule, serviceModule, databaseModule, repositoryModule, viewModelModule
            )
        }
    }
}
