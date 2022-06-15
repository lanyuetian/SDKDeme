package com.my.uuidtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.my.uuidtest.utils.OnlyIDUtil
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //UUID 每次安装都会变
        val userUUID = UUID.randomUUID().hashCode().toString()
        Log.e("userUUID: ", userUUID)
        //860680570
        //1365978425

        //Android_ID  重置规则：设备恢复出厂设置时，ANDROID_ID将被重置
        var userAndroidId =
            Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
        Log.e("userAndroidID: ", userAndroidId)
        //967fc9725b4289eb
        //967fc9725b4289eb
        //967fc9725b4289eb
        //967fc9725b4289eb

        var myId = OnlyIDUtil.getId(this)

    }
}