package israelontanilla.es.formacion2022.ui.main.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import israelontanilla.es.data.models.TransactionModel
import israelontanilla.es.formacion2022.R
import israelontanilla.es.formacion2022.common.getString
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
        val context = itemView.context
        fun bind(item: TransactionModel){
            Log.d("sample","sample")
            with(binding){
                tvItemHomeDate.text = item.date
                tvItemHomeAmount.text = item.amount
                tvItemHomeDescripcion.text = item.description
                tvItemHomeFee.text = item.fee

                kotlin.runCatching {
                    if (item.amount.toFloat()>=0f) {
                        tvItemHomeAmount.setTextColor(context.getColor(R.color.teal_200))
                        ivItemHome.setImageResource(R.drawable.ic_in)
                    }else {
                        tvItemHomeAmount.setTextColor(context.getColor(android.R.color.holo_red_dark))
                        ivItemHome.setImageResource(R.drawable.ic_out)
                    }

                    item.fee.also{ _fee ->
                        tvItemHomeFee.text = R.string.home_fee.getString(context, _fee)
                    }
                }



            }
        }
    }
}