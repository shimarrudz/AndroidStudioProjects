package br.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

// Classe principal da atividade, que herda da AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Função chamada quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade a partir do arquivo XML "activity_main.xml"
        setContentView(R.layout.activity_main)
    }

    // Função chamada quando o botão de cálculo é clicado
    fun calculate(view: View) {
        // Encontrando os campos de entrada da informacao alcool e gasolina no layout
        val editTextAlchool = findViewById<EditText>(R.id.editTextAlcohol)
        val editTextGasoline = findViewById<EditText>(R.id.editTextGasoline)

        // Obtém o texto dos campos de entrada
        val alcoholInput = editTextAlchool.text.toString()
        val gasolineInput = editTextGasoline.text.toString()

        // Verifica se os campos estão vazios
        if (alcoholInput.isEmpty() || gasolineInput.isEmpty()) {
            // Se um ou ambos os campos estiverem vazios, exibe um Toast informe ao usuário
            Toast.makeText(this, "Por favor, preencha ambos os campos", Toast.LENGTH_LONG).show()

            return // sair da função para evitar calculos invalidos
        }

        // Converter o texto dos campos em valores númericos (preços)
        val alcoholPrice = alcoholInput.toDoubleOrNull()
        val gasolinePrice = gasolineInput.toDoubleOrNull()

        // Verifica os valores inseridos são válidos (não nulos)
        if (alcoholPrice != null && gasolinePrice != null) {
            // Calcula se o alcool é vantajoso em relação a gasolina
            val result = if (alcoholPrice / gasolinePrice < 0.7) {
                "Alcool é vantajoso"
            } else {
                "Gasolina é vantajosa"
            }

            // Exibe um Toast com o resultado do calculo
            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }

    }
}