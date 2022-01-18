package israelontanilla.es.data.repository

import israelontanilla.es.data.models.TransactionModel
import israelontanilla.es.data.remote.TransactionAPI

class TransaccionRepository(
    private val transactionAPI: TransactionAPI
) {

    suspend fun  getTransactions(): List<TransactionModel>{
        return transactionAPI.getTransactions()
    }
}