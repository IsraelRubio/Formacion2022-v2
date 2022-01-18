package israelontanilla.es.data.models

data class TransactionModel(
    val id: String,
    val date: String,
    val amount: String,
    val descripcion: String?,
    val fee: String,
    val total: String
)