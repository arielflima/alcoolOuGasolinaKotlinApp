package com.example.alcoolougasolinakotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View) {

        //val precoAlcool = findViewById<EditText>(R.id.editAlcool)

        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos == true) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            textResultado.text = "Preencha os campos corretamente!"
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {


        //Converte atributo String para Double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        //Faz a conta
        val resultadoPreco = valorAlcool / valorGasolina


        //Altera o campo
        if (resultadoPreco >= 0.7) {
            textResultado.text = "Melhor utilizar gasolina!"
        } else {
            textResultado.text = "Melhor usar Alcool"
        }

    }
}
