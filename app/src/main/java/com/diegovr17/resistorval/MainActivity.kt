package com.diegovr17.resistorval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    lateinit var Spinner1B: Spinner
    lateinit var Spinner2B: Spinner
    lateinit var Spinner3B: Spinner
    lateinit var Spinner4B: Spinner

    lateinit var ImageR: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Spinner1B = findViewById(R.id.Spin1B) as Spinner
        Spinner2B = findViewById(R.id.Spin2B) as Spinner
        Spinner3B = findViewById(R.id.Spin3B) as Spinner
        Spinner4B = findViewById(R.id.Spin4B) as Spinner

        ImageR = findViewById(R.id.ImageRe) as ImageView


        var Banda1 = ""
        var Banda2 = ""
        var Banda3 = ""
        var Banda4 = ""


        var ValBanda1 =  arrayOf("Negro","Marrón","Rojo","Naranja","Amarillo","Verde","Azul","Púrpura","Gris","Blanco")
        Spinner1B.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,ValBanda1)
        Spinner1B.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                    Banda1 = "Negro"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Banda1 = ValBanda1[position]
            }

        }

        var ValBanda2 =  arrayOf("Negro","Marrón","Rojo","Naranja","Amarillo","Verde","Azul","Púrpura","Gris","Blanco")
        Spinner2B.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,ValBanda2)
        Spinner2B.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Banda2 = "Negro"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Banda2 = ValBanda2[position]
            }

        }

        var ValBanda3 = arrayOf("Negro","Marrón","Rojo","Naranja","Amarillo","Verde","Azul","Púrpura","Gris","Blanco")
        Spinner3B.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,ValBanda3)
        Spinner3B.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Banda3 = "Negro"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Banda3 = ValBanda3[position]
            }

        }

        var ValBanda4 = arrayOf("Marrón","Rojo","Dorado","Plateado")
        Spinner4B.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,ValBanda4)
        Spinner4B.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Banda4 = "Negro"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Banda4 = ValBanda4[position]
            }

        }


        ImageR.setOnClickListener(View.OnClickListener{


            tvConversion.text = ""
            var B_4 = ""

            when(Banda1){
                "Negro" -> tvConversion.append("0")
                "Marrón" -> tvConversion.append("1")
                "Rojo" -> tvConversion.append("2")
                "Naranja" ->tvConversion.append("3")
                "Amarillo" -> tvConversion.append("4")
                "Verde" -> tvConversion.append("5")
                "Azul" -> tvConversion.append("6")
                "Púrpura" -> tvConversion.append("7")
                "Gris" -> tvConversion.append("8")
                "Blanco" -> tvConversion.append("9")

             else -> tvConversion.text = "Error"
            }

            when(Banda2){
                "Negro" -> tvConversion.append("0")
                "Marrón" -> tvConversion.append("1")
                "Rojo" -> tvConversion.append("2")
                "Naranja" ->tvConversion.append("3")
                "Amarillo" -> tvConversion.append("4")
                "Verde" -> tvConversion.append("5")
                "Azul" -> tvConversion.append("6")
                "Púrpura" -> tvConversion.append("7")
                "Gris" -> tvConversion.append("8")
                "Blanco" -> tvConversion.append("9")

                else -> tvConversion.text = "Error"
            }

            when(Banda3){
                "Negro" -> tvConversion.append("*1")
                "Marrón" -> tvConversion.append("*10")
                "Rojo" -> tvConversion.append("*100")
                "Naranja" ->tvConversion.append("*1000")
                "Amarillo" -> tvConversion.append("*10000")
                "Verde" -> tvConversion.append("*100000")
                "Azul" -> tvConversion.append("*1000000")
                "Púrpura" -> tvConversion.append("*10000000")
                "Gris" -> tvConversion.append("*100000000")
                "Blanco" -> tvConversion.append("*1000000000")

                else -> tvConversion.text = "Error"
            }

            when(Banda4){
                "Marrón" -> B_4 = "±1"
                "Rojo" -> B_4 = "±2"
                "Dorado" -> B_4 = "±5"
                "Plateado" -> B_4 = "±10"

                else -> tvConversion.text = "Error"
            }

            try {
                val expression = ExpressionBuilder(tvConversion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvConversion.text = "El valor de R es: " + longResult.toString() + " Ohmios, " + B_4 + "% de tolerancia"
                } else {
                    tvConversion.text = "El valor de R es: " + result.toString()  + " Ohmios, " + B_4 + "% de tolerancia"
                }
            } catch (e: Exception) {
                Log.d("Exception", "message: " + e.message)

            }


        })
        tvConversion.text = ""
        Banda1 = ""
        Banda2 = ""
        Banda3 = ""
        Banda4 = ""



    }
}
