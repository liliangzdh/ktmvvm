package com.kaoyaya.kt.ui.main

import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.gyf.immersionbar.ktx.statusBarHeight
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.adapter.HomeExamAdapter
import com.kaoyaya.kt.databinding.ActivityMainBinding
import com.kaoyaya.kt.entity.ExamInfo
import com.kaoyaya.kt.ui.main.home.HomeFragment
import com.kaoyaya.kt.ui.main.study.StudyFragment
import com.kaoyaya.kt.ui.main.user.UserFragment
import com.kaoyaya.kt.view.TabItem
import com.kaoyaya.mvvmbase.base.BaseVMActivity
import com.kaoyaya.mvvmbase.utils.SizeUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener
import java.util.*


class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutId() = R.layout.activity_main

    private val examInfoList: MutableList<ExamInfo> = mutableListOf()
    private val homeExamAdapter by lazy { HomeExamAdapter(examInfoList) }

    override fun initVariableId() = BR.viewModel

    override fun initView() {
        (binding.drawerTop.layoutParams as LinearLayout.LayoutParams).setMargins(
            0,
            statusBarHeight,
            0,
            0
        )
        initBottomTab()
        initFragment()

        viewModel.request()
        initDrawerLayout()
    }

    private fun initDrawerLayout() {
        binding.examRecyclerView.adapter = homeExamAdapter
        homeExamAdapter.setOnItemClickListener { _, _, position ->

            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            if (examInfoList[position].isSelect) {
                return@setOnItemClickListener
            }
            for (i in examInfoList.indices) {
                if (examInfoList[i].isSelect != (i == position)) {
                    homeExamAdapter.notifyItemChanged(i)
                }
                examInfoList[i].isSelect = i == position
            }

            binding.drawerLayout.closeDrawers()
            // 这边储存。。
            viewModel.saveExamInfo(examInfoList[position])


            if (binding.leftDrawer.layoutParams.width == SizeUtils.getScreenWidth(this)) {
                lifecycleScope.launch {
                    delay(1000)
                    binding.leftDrawer.layoutParams.width = SizeUtils.dp2px(this@MainActivity, 245f)
                    binding.leftDrawer.layoutParams = binding.leftDrawer.layoutParams
                }
            }
        }

        if (viewModel.saveExamInfo.id == 0) {
            // 禁止滑动
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            binding.drawerLayout.openDrawer(Gravity.LEFT)
            binding.leftDrawer.layoutParams.width = SizeUtils.getScreenWidth(this)
        }
    }


    override fun initData() {

    }

    override fun startObserve() {

        viewModel.examInfoListLiveData.observe(this, Observer {
            examInfoList.clear()
            examInfoList.addAll(it)
            homeExamAdapter.notifyDataSetChanged()
        })

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