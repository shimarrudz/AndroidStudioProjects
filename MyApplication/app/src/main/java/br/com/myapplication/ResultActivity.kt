package br.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da tela com base na activity result
        setContentView(R.layout.activity_result)

        // Obtém a String de resultado passada da atividade anterior através da Intent
        val result = intent.getStringExtra("result")

        // Encontra o elemento de TextView no layout pelo seu ID
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        // Define o texto do TextView como a String de resultado obtida
        textViewResult.text = result


        // Cria um Toast (uma mensagem pop-up temporária) para exibir o resultado
        // com duração LONG (longa)
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    // Função associada ao botão voltar (onClick)
    fun goBack(view: View) {
        finish() // Fecha a atividade atual e volta para a tela anterior
    }
}