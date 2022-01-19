package israelontanilla.es.data.repository

import israelontanilla.es.data.database.AppDatabase
import israelontanilla.es.data.models.TransactionModel
import israelontanilla.es.data.remote.TransactionAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransaccionRepository(
    private val transactionAPI: TransactionAPI,
    private val db: AppDatabase
) {

    suspend fun  getTransactionsRemotely(): List<TransactionModel> =
        transactionAPI.getTransactions()

    suspend fun saveTransactions(vararg transactionModel: TransactionModel) =
        db.transaccionsDao().saveTransactions(*transactionModel)


    suspend fun getTransactionsLocally(): List<TransactionModel> =
        db.transaccionsDao().getTransactions()

    suspend fun deleteTransactions() =
        db.transaccionsDao().deleteTransactions()

    suspend fun getTransactionsAndSave(): List<TransactionModel>? {
        return withContext(Dispatchers.IO) {
            val data = getTransactionsRemotely()
            saveTransactions(*data.toTypedArray())
            data
        }
    }

}