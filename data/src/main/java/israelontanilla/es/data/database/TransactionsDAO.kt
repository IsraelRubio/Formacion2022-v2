package israelontanilla.es.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import israelontanilla.es.data.models.TransactionModel

@Dao
interface TransactionsDAO {

    @Query("SELECT * FROM ${TransactionModel.TABLE.NAME}")
    fun getTransactions():List<TransactionModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTransactions(vararg transactionModel: TransactionModel)

    @Query("DELETE FROM ${TransactionModel.TABLE.NAME}")
    fun deleteTransactions()
}