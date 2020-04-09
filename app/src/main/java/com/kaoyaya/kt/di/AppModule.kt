package com.kaoyaya.kt.di

import com.kaoyaya.kt.ui.login.LoginViewModel
import com.kaoyaya.kt.ui.main.MainViewModel
import com.kaoyaya.kt.ui.main.home.HomeViewModel
import com.kaoyaya.kt.ui.main.study.StudyViewModel
import com.kaoyaya.kt.ui.main.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }

    viewModel { HomeViewModel() }
    viewModel { StudyViewModel() }
    viewModel { UserViewModel() }
}


val appModule = listOf(viewModelModule)
