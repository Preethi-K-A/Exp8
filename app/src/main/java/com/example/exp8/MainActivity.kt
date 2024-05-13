package com.example.exp8

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.gsm.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.arrayOf
import kotlin.arrayOf as kotlinArrayOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
            val SMS_PERMISSION_CODE = 0
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), SMS_PERMISSION_CODE)
        }
        val ph:EditText=findViewById(R.id.tv1)
        val msg:EditText=findViewById(R.id.tv2)
        val send:Button=findViewById(R.id.send)
        send.setOnClickListener {
            val ph = ph.text.toString()
            val msg = msg.text.toString()
            val SmsManager = SmsManager.getDefault()
            SmsManager.sendTextMessage(/* destinationAddress = */ ph,/* scAddress = */
                null,/* text = */
                msg,/* sentIntent = */
                null,/* deliveryIntent = */
                SmsManager)
        }
    }
}

private fun SmsManager.sendTextMessage(ph: String, nothing: Nothing?, msg: String, nothing1: Nothing?, smsManager: SmsManager?) {

}