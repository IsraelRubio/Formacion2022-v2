package israelontanilla.es.formacion2022.ui.main.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import israelontanilla.es.data.models.TransactionModel
import israelontanilla.es.formacion2022.databinding.ItemHomeBinding

class HomeAdapter(
    private val transaccionesList: List<TransactionModel> = emptyList()
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var mutableTransactionList: MutableList<TransactionModel> = mutableListOf(*transaccionesList.toTypedArray())

    fun updateList(list: List<TransactionModel>){
        mutableTransactionList.clear()
        mutableTransactionList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(mutableTransactionList[position])
    }

    override fun getItemCount(): Int = mutableTransactionList.size

    class HomeViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
        // comprobar que no este ningun campo vacio
        fun bind(item: TransactionModel){
            Log.d("sample","sample")
            with(binding){
                tvItemHomeDate.text = item.date
                tvItemHomeAmount.text = item.amount
                tvItemHomeDescripcion.text = item.descripcion
                tvItemHomeFee.text = item.fee
            }
        }
    }
}