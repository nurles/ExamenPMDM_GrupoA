package examen.pmdm.grupoa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editText = findViewById<EditText>(R.id.editTextSecondActivity)
        val textView = findViewById<TextView>(R.id.textViewSecondActivity)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        val texto = intent.getStringExtra("Hola")

        texto?.let {
            textView.text = it.replace(" ", "\n")
        }

        button1.setOnClickListener {
            texto?.let {
                textView.text = darTamano(it)
            }
        }

        button2.setOnClickListener {
            texto?.let {
                textView.text = ordenarPorTamano(it)
            }
        }

        button3.setOnClickListener {
            texto?.let {
                textView.text = filtrarPorTamano(it, editText.text.toString().toInt())
            }
        }
    }

    private fun filtrarPorTamano(texto: String, valorFiltrado: Int) : String {
        val lista = texto.split(" ")
        lista.filter{
            it.length >= valorFiltrado
        }
        return lista.toString()
    }

    private fun ordenarPorTamano(texto: String) : String{
        val lista = texto.split(" ")
        lista.sortedByDescending {
            it.length
        }
        return lista.toString()
    }

    private fun darTamano(texto : String) : String {
        val lista = texto.split(" ")

        var salida = ""
        lista.forEach {
            salida += it + " " + it.length + "\n"
        }
        return salida
    }
}