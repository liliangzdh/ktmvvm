package com.kaoyaya.kt

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kaoyaya.kt.entity.AppVersion
import com.kaoyaya.mvvmbase.entity.BaseResponse
import com.kaoyaya.kt.http.AppApi
import com.kaoyaya.mvvmbase.http.base.RetrofitClient
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        tvName.setOnClickListener {
            //            getHttp()
            testSuspend()
        }

        let()

        btn.setOnClickListener {
            Toast.makeText(this, "hek", Toast.LENGTH_SHORT).show()
        }
    }


//    private fun getHttp() {
//        val appApi = RetrofitClient.create(AppApi::class.java)
//
//        GlobalScope.launch(Dispatchers.Main) {
//            Log.e("test", "34:" + Thread.currentThread().name)
//            // todo 这里的代码块是 不管同步还是异步，都是 一步一步执行的。
//            // 因为请求耗时。所以在 IO调度单元 来 获取响应、
//            // withContext 可以有返回值。默认就是最高一行返回。
//            val res = withContext(Dispatchers.IO) {
//
//                Log.e("test", "37" + Thread.currentThread().name)
//                var data: BaseResponse<AppVersion>? = null
//                try {
//                    data = appApi.getLastVersionAsync().await()
//                } catch (e: Exception) {
//
//                }
//                data
//            }
//            Log.e("test", "41: ${res?.code}")
//        }
//    }


    private fun testSuspend() {
        val appApi = RetrofitClient.create(AppApi::class.java)
        GlobalScope.launch(Dispatchers.Main) {


         val response =    withContext(Dispatchers.IO) {
                val data: BaseResponse<AppVersion>?
                data = appApi.getLastVersion()

                Log.e("test","${data?.code}")
                data
            }



            Log.e("test","27:${response?.code}  =  " )
            tvName.setText("hello")
        }
    }

    fun let(){
        val version = AppVersion()
        val result = version.let {
            Log.e("test",it.versionCode.toString())
            1000
        }
        Log.e("test",result.toString())
    }

    fun also(){
       var res =  "lll".also {

        }
    }

    fun apply(){
        val version = AppVersion()
        val res =  version.apply {

        }
    }


    fun with(){
        val version = AppVersion()
        var res = with(version){

        }
    }

    // run = let + with
    fun run(){
        val version = AppVersion()
        var res = version.run {

        }
    }



}






