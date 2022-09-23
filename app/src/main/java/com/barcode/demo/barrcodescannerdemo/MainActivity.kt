package com.barcode.demo.barrcodescannerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var barcode = ""
    var s =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    override fun dispatchKeyEvent(e: KeyEvent): Boolean {
        val textView2 = findViewById<TextView>(R.id.textViewLog)


        if (e.action == KeyEvent.ACTION_DOWN) {
            Log.i("TAG_MainActivity", "dispatchKeyEvent: $e")
            //Toast.makeText(this, "dispatchKeyEvent: $e", Toast.LENGTH_LONG).show()
            s = s + "\n" + "dispatchKeyEvent: $e"
            val pressedKey = e.unicodeChar.toChar()
            barcode += pressedKey
        }
        if (e.action == KeyEvent.ACTION_DOWN && e.keyCode == KeyEvent.KEYCODE_ENTER) {
            Toast.makeText(
                applicationContext,
                "barcode--->>>$barcode", Toast.LENGTH_LONG
            )
                .show()
            barcode = ""
        }
        textView2.text = s
        return super.dispatchKeyEvent(e)
    }

    private fun initListeners() {
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        var count = 0

        button.setOnClickListener {
            count++
            textView.text = "Button clicks: $count"
        }
    }
}