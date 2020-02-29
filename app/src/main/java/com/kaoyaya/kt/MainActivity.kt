package com.kaoyaya.kt

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kaoyaya.kt.entity.AppVersion
import com.kaoyaya.kt.entity.BaseResponse
import com.kaoyaya.kt.http.AppApi
import com.kaoyaya.kt.http.base.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvName.setOnClickListener {
            getHttp()
        }


        btn.setOnClickListener {
            Toast.makeText(this, "hek", Toast.LENGTH_SHORT).show()
        }
    }


    fun getHttp() {
        val appApi = RetrofitClient.create(AppApi::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            Log.e("test", "34:" + Thread.currentThread().name)
            // todo 这里的代码块是 不管同步还是异步，都是 一步一步执行的。
            // 因为请求耗时。所以开启一个子 协程 来 获取响应、
            // withContext 可以有返回值。默认就是最高一行返回。
            val res = withContext(Dispatchers.IO) {

                Log.e("test", "37" + Thread.currentThread().name)
                var data: BaseResponse<AppVersion>? = null
                try {
                    data = appApi.getLastVersionAsync().await()
                } catch (e: Exception) {

                }
                data
            }
            Log.e("test", "41: ${res?.code}")
        }
    }


}






