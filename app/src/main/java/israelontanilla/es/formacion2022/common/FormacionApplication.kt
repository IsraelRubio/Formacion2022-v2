package israelontanilla.es.formacion2022.common

import android.app.Application
import israelontanilla.es.data.di.dataModule
import israelontanilla.es.formacion2022.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FormacionApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FormacionApplication)
            modules(
                listOf(
                    uiModule,
                    dataModule
                )
            )
        }
    }

}