package com.example.conversortemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTemperature = findViewById<EditText>(R.id.editTextTemperature)
        val radioButtonCelsiusToFahrenheit = findViewById<RadioButton>(R.id.radioButtonCelsiusToFahrenheit)
        val radioButtonFahrenheitToCelsius = findViewById<RadioButton>(R.id.radioButtonFahrenheitToCelsius)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val temperature = editTextTemperature.text.toString().toFloatOrNull()

            if (temperature != null) {
                val result = when {
                    radioButtonCelsiusToFahrenheit.isChecked -> (temperature * 9/5) + 32
                    radioButtonFahrenheitToCelsius.isChecked -> (temperature - 32) * 5/9
                    else -> null
                }

                if (result != null) {
                    textViewResult.text = "Resultado: %.2f".format(result)
                } else {
                    textViewResult.text = "Por favor, selecione uma conversão."
                }
            } else {
                textViewResult.text = "Por favor, insira uma temperatura válida."
            }
        }
    }
}