package com.example.deporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// contador de vueltas realizadas
    var count =0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //funcion  de clickeo largo dependiendo de si tiene mas o menos de 10 vueltas se muestra un mensaje determinado
            increase.setOnLongClickListener {
                if (count< 10){
                Toast.makeText(this,"Faltan "+ (10-count)+ " vueltas para premio",Toast.LENGTH_LONG).show()

            }
                else{
                    Toast.makeText(this,"Faltan "+ (20-count)+ " vueltas para finalizar",Toast.LENGTH_LONG).show()


                }
            true
            }

        //boton para reiniciar el conteo de vueltas y borrar las imagenes mostradas
        reset.setOnClickListener {
            count =0
            val textview = findViewById(R.id.lapcounter) as TextView
            textview.text = count.toString()
            congrats.setImageResource(0)
        }

        //boton para aumentar las vueltas realizadas asi como para mostrar las imagenes de felicitacion dependiendo de la cantidad realizada
        increase.setOnClickListener {

            if (count < 20) {

                if (count == 9){
                    congrats.setImageResource(R.drawable.felicitacion)
                    Toast.makeText(this,"Felicitaciones",Toast.LENGTH_LONG).show()
                }
                else if (count >= 19){
                    congrats.setImageResource(R.drawable.cumplido)
                    Toast.makeText(this,"Cumplido",Toast.LENGTH_LONG).show()
                }
                count++
                val textview = findViewById(R.id.lapcounter) as TextView
                textview.text = count.toString()
            }
        }
    }
}
