package examen.pmdm.grupoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        editText.movementMethod = ScrollingMovementMethod()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                //Comprobamos que no es nulo con el let
                s?.let{
                    if(s.split(" ").size >= 4){
                        button.isEnabled = it.split(" ").size >= 4
                    }
                }

            }

        })

        button.setOnClickListener{
            val text = editText.text
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Hola", text.toString())
            startActivity(intent)
        }
    }
}