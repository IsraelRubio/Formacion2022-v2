package israelontanilla.es.data.di

import israelontanilla.es.data.remote.MockInterceptor
import israelontanilla.es.data.remote.TransactionAPI
import israelontanilla.es.data.repository.TransaccionRepository
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
            .baseUrl("https://www.back.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TransactionAPI::class.java)
    }

    single<TransaccionRepository> {
        TransaccionRepository(get())
    }
}