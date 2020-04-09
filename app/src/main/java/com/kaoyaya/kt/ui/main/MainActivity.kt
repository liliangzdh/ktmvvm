package com.kaoyaya.kt.ui.main

import android.graphics.Color
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.ActivityMainBinding
import com.kaoyaya.kt.ui.main.home.HomeFragment
import com.kaoyaya.kt.ui.main.study.StudyFragment
import com.kaoyaya.kt.ui.main.user.UserFragment
import com.kaoyaya.kt.view.TabItem
import com.kaoyaya.mvvmbase.base.BaseVMActivity
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.ArrayList


class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutId() = R.layout.activity_main

//    override fun initVM(): MainViewModel = getViewModel()

    override fun initVariableId() = BR.viewModel

    override fun initView() {
        val params = binding.drawerTop.layoutParams as LinearLayout.LayoutParams
        params.setMargins(0, ImmersionBar.getStatusBarHeight(this), 0, 0)
        binding.drawerTop.layoutParams = params

        initBottomTab()
        initFragment()
    }


    override fun initData() {

    }

    override fun startObserve() {

    }

    private val mFragments = ArrayList<Fragment>()

    private val cacheFragments = ArrayList<Fragment>()

    private fun initFragment() {
        mFragments.clear()
        cacheFragments.clear()
        mFragments.add(HomeFragment())
        mFragments.add(StudyFragment())
        mFragments.add(UserFragment())

        //默认选中第一个
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mFragments[0])
        cacheFragments.add(mFragments[0])
        transaction.commitAllowingStateLoss()
    }

    private fun initBottomTab() {
        val controller =
            binding.pagerBottomTab.custom()
                .addItem(newItem(R.mipmap.home_xx, R.mipmap.home_jy, "首页"))
                .addItem(newItem(R.mipmap.lean_xx, R.mipmap.learn_jy, "学习"))
                .addItem(newItem(R.mipmap.my_xx, R.mipmap.my_jy, "我的")).build()


        controller.addTabItemSelectedListener(object : OnTabItemSelectedListener {
            override fun onSelected(index: Int, old: Int) {
                val transaction = supportFragmentManager.beginTransaction()

                val oldFragment = mFragments[old]
                val newFragment = mFragments[index]

                transaction.hide(oldFragment)

                if (!cacheFragments.contains(newFragment)) {
                    cacheFragments.add(newFragment)
                    transaction.add(R.id.frameLayout, newFragment)
                } else {
                    transaction.show(newFragment)
                    when (newFragment) {
                        is HomeFragment -> newFragment.initStatusBar()
                        is StudyFragment -> newFragment.initStatusBar()
                        is UserFragment -> newFragment.initStatusBar()
                    }
                }
                transaction.commit()
            }

            override fun onRepeat(index: Int) {

            }
        })
    }

    //创建一个Item
    private fun newItem(drawable: Int, checkedDrawable: Int, text: String): BaseTabItem {
        val normalItemView = TabItem(this)
        normalItemView.initialize(drawable, checkedDrawable, text)
        normalItemView.setTextDefaultColor(Color.GRAY)
        normalItemView.setTextCheckedColor(resources.getColor(R.color.colorPrimary))
        return normalItemView
    }

}