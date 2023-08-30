package com.unibosque.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class NumberGuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
        var numero : Int = 0
        var intentos : Int = 0
        var numeroAleatorio : Int = Random.nextInt(1,1000)
        val tv = findViewById<TextView>(R.id.Pistas)
        val te = findViewById<EditText>(R.id.editTextNumber)
        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            intentos ++
            numero = te.text.toString().toInt()
            if(numero == numeroAleatorio){
                Toast.makeText(this@NumberGuessActivity,
                    "Has ganado!. Te ha tomado $intentos intento(s).", Toast.LENGTH_SHORT).show()
                te.text = null
                numeroAleatorio = Random.nextInt(1,1000)
                intentos=0
                tv.text = "Pistas: "
            }else if(numero < numeroAleatorio){
                tv.text = "Pistas: El número es mayor."
                Toast.makeText(this@NumberGuessActivity, "El número es mayor.", Toast.LENGTH_SHORT).show()
            }else{
                tv.text = "Pistas: El número es menor."
                Toast.makeText(this@NumberGuessActivity, "El número es menor.", Toast.LENGTH_SHORT).show()
            }
        }


    }


}