package israelontanilla.es.formacion2022.data.di

import androidx.room.Room
import israelontanilla.es.data.BuildConfig
import israelontanilla.es.data.database.AppDatabase
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
        TransaccionRepository(get(), get())
    }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            BuildConfig.DB_NAME)
            .build()
    }


}