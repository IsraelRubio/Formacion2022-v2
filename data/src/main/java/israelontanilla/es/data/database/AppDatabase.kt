package israelontanilla.es.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import israelontanilla.es.data.models.TransactionModel

@Database(
    entities = [
        TransactionModel::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transaccionsDao(): TransactionsDAO

}