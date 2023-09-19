package br.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cliqueBotao(view: View) {
        val imagem = findViewById<ImageView>(R.id.imagem)

        when (view.id) {
            R.id.btn1 -> imagem.setImageResource(R.drawable.dino1)
            R.id.btn2 -> imagem.setImageResource(R.drawable.dino2)
            R.id.btn3 -> imagem.setImageResource(R.drawable.dino3)
        }
    }
}