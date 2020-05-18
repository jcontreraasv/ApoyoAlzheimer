package jaime.contreras.apoyoalzheimer.juegos

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_juego_colores.*

class JuegoColoresActivity : AppCompatActivity() {

    var colores = ArrayList<Colores>()
    var index:Int=0

    //BUSCAR SOBRE RANDOM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_colores)


        val dialog= AlertDialog.Builder(this)
        val dialogView=layoutInflater.inflate(R.layout.activity_juego_colores_dialog,null)

        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
        dialog.show()

        colores.add(Colores("ROJO","VERDE","AMARILLO","NEGRO",

            /*"MORADO","AZUL","ROJO","VERDE",
            "NEGRO","ROSA","AZUL","MORADO",
            "AMARILLO","ROJO","VERDE","AZUL",
             */

            "",1))

        colores.add(Colores("AMARILLO","ROJO","VERDE","AZUL",

            /*"ROJO","VERDE","AMARILLO","NEGRO",
            "NEGRO","ROSA","AZUL","MORADO",
            "MORADO","AZUL","ROJO","VERDE",

             */
            "",1))

        mostrarColores(colores.get(index))

    }

    fun mostrarColores(colores: Colores){
        color1.setText(colores.color1)
        //color1.setTextColor(Color.parseColor("#ff0000"))

        color2.setText(colores.color2)
        //color2.setTextColor(Color.parseColor("#ff0000"))

        color3.setText(colores.color3)
        //color3.setTextColor(Color.parseColor("#ff0000"))

        color4.setText(colores.color4)
        //color4.setTextColor(Color.parseColor("#ff0000"))

        /*
        color5.setText(colores.color5)
        //color5.setTextColor(Color.parseColor("#ff0000"))

        color6.setText(colores.color6)
        //color6.setTextColor(Color.parseColor("#ff0000"))

        color7.setText(colores.color7)
        //color7.setTextColor(Color.parseColor("#ff0000"))

        color8.setText(colores.color8)
        //color8.setTextColor(Color.parseColor("#ff0000"))

        color9.setText(colores.color9)
        //color9.setTextColor(Color.parseColor("#ff0000"))

        color10.setText(colores.color10)
        //color10.setTextColor(Color.parseColor("#ff0000"))

        color11.setText(colores.color11)
        //color11.setTextColor(Color.parseColor("#ff0000"))

        color12.setText(colores.color12)
        //color12.setTextColor(Color.parseColor("#ff0000"))

        color13.setText(colores.color13)
        //color13.setTextColor(Color.parseColor("#ff0000"))

        color14.setText(colores.color14)
        //color14.setTextColor(Color.parseColor("#ff0000"))

        color15.setText(colores.color15)
        //color15.setTextColor(Color.parseColor("#ff0000"))

        color16.setText(colores.color16)
        //color16.setTextColor(Color.parseColor("#ff0000"))


         */
        nextColour.setText(colores.sig)
    }

    fun handleAnswer(answerID: Int){

        val nuevoColor=colores.get(index)

        if(nuevoColor.siguienteColor(answerID)){
            Toast.makeText(this, "Siguiente color", Toast.LENGTH_SHORT).show()
        }
        index++

        if(index >= colores.size){
            var alert= AlertDialog.Builder(this)
            alert.setTitle("Juego finalizado.")

            alert.setPositiveButton("Continuar"){ dialog: DialogInterface?, which: Int ->
                finish()
            }
            alert.show()
        }else{
            mostrarColores(colores.get(index))
            }
    }

    fun nextColor1(view: View){
        handleAnswer(1)
    }

    fun nextColor2(view: View){
        handleAnswer(2)
    }
}
