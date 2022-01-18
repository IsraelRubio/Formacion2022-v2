package israelontanilla.es.formacion2022.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<T:ViewBinding> : Fragment() {

    private var _binding : T? = null
    protected val binding
        get() = _binding!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = provideBinding(inflater)
        return binding.root
    }

    abstract fun provideBinding(inflater: LayoutInflater): T

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}