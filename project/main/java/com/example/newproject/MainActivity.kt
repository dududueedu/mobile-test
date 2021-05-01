package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    lateinit var campo1: EditText
    lateinit var botao1: Button
    //
    lateinit var texto: TextView
    lateinit var seekBar: SeekBar
    lateinit var botao2: Button
    //
    lateinit var textoRatingBar: TextView
    lateinit var ratingBar: RatingBar
    lateinit var botao3: Button
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//chamada para tela1

        campo1 = findViewById(R.id.nome)
        botao1 = findViewById(R.id.botao)

        botao1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, campo1.text.toString() + " você é capaz, acredite!!!", Toast.LENGTH_LONG).show()

                setContentView(R.layout.screensecond)
                texto = findViewById(R.id.textSeek)
                seekBar = findViewById(R.id.seekBar)
                botao2 = findViewById(R.id.button2)

                seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        texto.text = "" + progress
                    }

                    override fun onStartTrackingTouch(seekBar01: SeekBar?) {}

                    override fun onStopTrackingTouch(seekBar01: SeekBar?) {}
                })
                botao2.setOnClickListener{
                    Toast.makeText(applicationContext, "Nível de Felicidade: "+ seekBar.progress, Toast.LENGTH_LONG).show()
                    //chamada para tela3
                    setContentView(R.layout.screenthree)
                    textoRatingBar = findViewById(R.id.textRatingBar)
                    ratingBar = findViewById(R.id.ratingBar)
                    botao3 = findViewById(R.id.button)

                    textoRatingBar.text = "Avalie nosso App:"
                    ratingBar.setOnRatingBarChangeListener{ratingBar, rating, fromUser -> rating
                        textoRatingBar.text = "Avalie: "+rating
                    }
                    botao3.setOnClickListener{
                        Toast.makeText(applicationContext, "Sua avaliação foi "+ratingBar.rating +", obrigado!", Toast.LENGTH_LONG).show()
                        //Thread.sleep(3000)
                    }
                }
            }
        })
    }
}