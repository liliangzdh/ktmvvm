package com.kaoyaya.kt.di

import com.kaoyaya.kt.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }
}


val appModule = listOf(viewModelModule)
