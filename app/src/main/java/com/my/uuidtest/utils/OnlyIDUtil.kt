package com.my.uuidtest.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES.Q
import android.provider.Settings
import android.telephony.TelephonyManager
import java.lang.Exception
import java.util.*

/**
 * Create by ldd
 * 日期：2022/4/24
 */
class OnlyIDUtil {
    companion object {
        fun getId(context: Context): String {
            var onlyId = ""
            if (getIMEI(context) != null) {
                onlyId = getIMEI(context)!!
            } else {
                onlyId = getAndroidID(context)
            }
            if (onlyId == null) {
                onlyId = getUUID()
            }
            return onlyId
        }

        @SuppressLint("HardwareIds")
        private fun getAndroidID(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        private fun getUUID(): String {
            var uuid = UUID.randomUUID().hashCode()
            if (uuid < 0) {
                uuid = -uuid
            }
            return uuid.toString()
        }

        @SuppressLint("ServiceCast", "HardwareIds")
        private fun getIMEI(context: Context): String? {
            if (Build.VERSION.SDK_INT >= Q) {
                return null
            }
            try {
                val telManager: TelephonyManager =
                    context.getSystemService(Context.TELECOM_SERVICE) as TelephonyManager
                if (telManager == null) {
                    return null
                }
                val imei = telManager.deviceId
                return imei

            } catch (ex: Exception) {
                return null
            }
        }
    }
}