package br.com.mvalbuquerque.appcasdastro

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome = findViewById<EditText>(R.id.textNome)
        val editTextTelefone = findViewById<EditText>(R.id.textTelefone)
        val editTextEmail = findViewById<EditText>(R.id.textEmail)
        val spinnerTipoTelefone = findViewById<Spinner>(R.id.spinnerTipoTelefone)
        val checkBoxTelefone = findViewById<CheckBox>(R.id.checkBoxTelefone)
        val checkBoxEmail = findViewById<CheckBox>(R.id.checkBoxEmail)
        val buttonMostrarMensagem = findViewById<Button>(R.id.button)

        // Configurar o adapter para o Spinner de Tipo de Telefone
        val tiposTelefone = arrayOf("Residencial", "Comercial")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposTelefone)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoTelefone.adapter = adapter

        buttonMostrarMensagem.setOnClickListener(View.OnClickListener {
            // Capturar os valores dos campos
            val nome = editTextNome.text.toString()
            val telefone = editTextTelefone.text.toString()
            val email = editTextEmail.text.toString()
            val tipoTelefone = spinnerTipoTelefone.selectedItem.toString()
            val contatoTelefone = checkBoxTelefone.isChecked
            val contatoEmail = checkBoxEmail.isChecked


            // Realizar validação dos campos
            if (nome.isEmpty() || (telefone.isEmpty() && email.isEmpty())) {
                showAlert("Preencha o nome e pelo menos um dos campos de telefone ou email.")
                return@OnClickListener
            }


            // Realizando validação dos campos
            if (nome.isEmpty()) {
                showAlert("Preencha o campo Nome.")
                return@OnClickListener
                //@OnClickListener é uma etiqueta que especifica qual função ou escopo deve ser
                //retornada. Isso é útil quando você tem várias funções anônimas em um mesmo escopo
                //e deseja retornar de uma específica.
            }

            if (!contatoTelefone && !contatoEmail) {
                showAlert("Selecione pelo menos uma preferência de contato (Telefone ou Email).")
                return@OnClickListener
            }

            if (contatoTelefone && telefone.isEmpty()) {
                showAlert("Preencha o campo Telefone ou desmarque a preferência de Telefone.")
                return@OnClickListener
            }

            if (contatoEmail && email.isEmpty()) {
                showAlert("Preencha o campo Email ou desmarque a preferência de Email.")
                return@OnClickListener
            }

            // Construir a mensagem com base nas preferências
            val mensagem = StringBuilder("Nome: $nome\n")

            if (contatoTelefone && !telefone.isEmpty()) {
                mensagem.append("Tipo: $tipoTelefone\n")
                mensagem.append("Telefone: $telefone\n")
            }
            if (contatoEmail && !email.isEmpty()) {
                mensagem.append("Email: $email\n")
            }
            if (checkBoxTelefone.isChecked) {
                mensagem.append("Contato Telefone")
            }
            if (checkBoxEmail.isChecked) {
                mensagem.append("\n Contato Email")
            }

             // Mostrar a mensagem em um Toast
            //  Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()

            // Exibir informações em um AlertDialog
            showInfoDialog("Informações Digitadas", mensagem)


        })
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ops")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showInfoDialog(title: String, message: StringBuilder) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

}





