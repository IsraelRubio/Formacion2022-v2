package israelontanilla.es.formacion2022.data.di

import israelontanilla.es.data.BuildConfig
import israelontanilla.es.formacion2022.data.remote.TransactionAPI
import israelontanilla.es.formacion2022.data.repository.TransaccionRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val dataModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(MockInterceptor(get()))
            .build()
    }

    single <TransactionAPI> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TransactionAPI::class.java)
    }

    single<TransaccionRepository> {
        TransaccionRepository(get())
    }
}