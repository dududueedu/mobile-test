package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var campo1: EditText
    lateinit var botao1: Button
    //
    lateinit var textoRatingBar: TextView
    lateinit var ratingBar: RatingBar
    lateinit var botao2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//chamada para tela1

        campo1 = findViewById(R.id.nome)
        botao1 = findViewById(R.id.botao)

        botao1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, campo1.text.toString() + " é lindo e se garante!!!", Toast.LENGTH_LONG).show()

                //chamada para tela2
                setContentView(R.layout.second_screen)
                textoRatingBar = findViewById(R.id.textRatingBar)
                ratingBar = findViewById(R.id.ratingBar)
                botao2 = findViewById(R.id.button)

                textoRatingBar.text = "Avalie:"
                ratingBar.setOnRatingBarChangeListener{ratingBar, rating, fromUser -> rating
                    textoRatingBar.text = "Avalie: "+rating
                }
                botao2.setOnClickListener{
                    Toast.makeText(applicationContext, "Sua avaliação foi "+ratingBar.rating, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}