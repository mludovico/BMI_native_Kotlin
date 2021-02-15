package com.example.bminativekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    var peso: String? = ""
    var altura: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("Lifecycle", "Entered onCerate handler method")
        setListeners()
    }

    private fun setListeners() {
        calcularButton?.setOnClickListener {
            val intent: Intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", peso)
            intent.putExtra("height", altura)
            startActivity(intent)
        }
        pesoEdit.doOnTextChanged { text, _, _, count ->
            val value = text?.toString()?.toFloatOrNull()
            peso = if(count > 0 && value != null)
                text.toString()
            else
                ""
            validate()
        }
        alutraEdit.doOnTextChanged { text, _, _, count ->
            val value = text?.toString()?.toFloatOrNull()
            altura = if (count > 0 && value != null)
                text.toString()
            else
                ""
            validate()
        }
    }

    private fun validate() {
        calcularButton.isEnabled = (peso != "" && altura != "")
    }

}