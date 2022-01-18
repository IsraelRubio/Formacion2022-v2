package israelontanilla.es.formacion2022.di

import israelontanilla.es.formacion2022.ui.main.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel{
        HomeViewModel(get())
    }
}