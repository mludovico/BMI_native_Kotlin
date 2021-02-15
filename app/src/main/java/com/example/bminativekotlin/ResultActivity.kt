package com.example.bminativekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_result.*
import java.util.function.Consumer
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val weight = intent.getStringExtra("weight")
        val height = intent.getStringExtra("height")

        calculateBmi(weight ?: "0", height ?: "0")
    }

    private fun calculateBmi(weight: String, height: String) {
        val peso = weight.toFloatOrNull()
        val altura = height.toFloatOrNull()

        if(peso != null && altura != null) {
            val bmi = peso / altura.pow(2)
            resultadoText.text = "Seu IMC é %.2f".format(bmi)
        }
    }
}