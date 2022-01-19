package israelontanilla.es.data.remote

import israelontanilla.es.data.models.TransactionModel
import retrofit2.http.GET

interface TransactionAPI {

    @GET("transactions.json")
    suspend fun getTransactions(): List<TransactionModel>
}