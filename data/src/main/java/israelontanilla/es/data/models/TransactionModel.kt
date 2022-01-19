package israelontanilla.es.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TransactionModel.TABLE.NAME)
data class TransactionModel(
    @PrimaryKey
    @ColumnInfo(name = TABLE.ID)
    val id: String,
    @ColumnInfo(name = TABLE.DATE)
    val date: String,
    @ColumnInfo(name = TABLE.AMOUNT)
    val amount: String,
    @ColumnInfo(name = TABLE.DESCRIPTION)
    val description: String?,
    @ColumnInfo(name = TABLE.FEE)
    val fee: String?,
    @ColumnInfo(name = TABLE.TOTAL)
    val total: String?
){
    companion object TABLE {
        const val NAME = "transactions"
        const val DATE = "date"
        const val ID = "id"
        const val AMOUNT = "amount"
        const val DESCRIPTION = "description"
        const val FEE = "fee"
        const val TOTAL = "total"
    }
}