package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import com.example.aidlserver.IMyAidlInterface
import java.security.SecureRandom

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        // Return the communication channel to the service.
        return MyBinder()
    }

    inner class MyBinder : IMyAidlInterface.Stub() {

        override fun getStr(): String {
            return "20230323test"
        }

        /**
         * 生成15位随机数
         */
        @Throws(RemoteException::class)
        override fun get15RandomString(): String {
            val length = 15
            val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
            val random = SecureRandom()
            val sb = StringBuilder(length)
            for (i in 0 until length) { // 从字符集中随机选择一个字符，并将其添加到生成的字符串中
                sb.append(characters[random.nextInt(characters.length)])
            }
            return sb.toString()
        }

        /**
         * 生成15位数随机数
         *
         * @param length 15
         * @param chaStr "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
         * @return 随机数
         */
        @Throws(RemoteException::class)
        override fun get15RandomStringPhrase(length: Int, chaStr: String): String {
            val random = SecureRandom()
            val sb = StringBuilder(length)
            for (i in 0 until length) { // 从字符集中随机选择一个字符，并将其添加到生成的字符串中
                sb.append(chaStr[random.nextInt(chaStr.length)])
            }
//            return sb.toString()
            return "fuck me!"
        }
    }
}
