package israelontanilla.es.formacion2022.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import israelontanilla.es.formacion2022.common.BaseFragment
import israelontanilla.es.formacion2022.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    private val vm by viewModel<HomeViewModel>()

    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun provideBinding(inflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            rvHome.adapter = homeAdapter
        }
        vm.onInit()
        setupBinding()
    }

    private fun setupBinding(){
        vm.obsListTransactions.observe(viewLifecycleOwner){
            homeAdapter.updateList(it)
        }
    }
}