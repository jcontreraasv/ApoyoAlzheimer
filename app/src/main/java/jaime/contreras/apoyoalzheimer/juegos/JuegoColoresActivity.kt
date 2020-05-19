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
    var index: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_colores)

        var alert= AlertDialog.Builder(this)

        alert.setTitle("INSTRUCCIONES Juego colores")
        alert.setMessage("El objetivo de este ejercicio es decir lo más rápido que pueda el color de " +
                "la palabra sin equivocarse para trabajar ambos hemisferios del cerebro.")
        alert.setPositiveButton("Iniciar",{ dialog: DialogInterface?, which: Int -> })
        alert.show()

        colores.add(Colores("ROJO","VERDE","AMARILLO","NEGRO",
            "MORADO","AZUL","ROJO","VERDE",
            "NEGRO","ROSA","AZUL","MORADO",
            "AMARILLO", "ROJO","VERDE","AZUL",
            "",1))

        colores.add(Colores("AMARILLO","ROJO","VERDE","AZUL",
            "ROJO","VERDE","AMARILLO","NEGRO",
            "NEGRO","ROSA","AZUL","MORADO",
            "MORADO","AZUL","ROJO","VERDE",
            "",1))

        colores.add(Colores("VERDE","NEGRO","VERDE","AMARILLO",
            "MORADO","LILA","MORADO","NEGRO",
            "ROSA","BEIGE","CAFÉ","BLANCO",
            "VERDE","ROJO","NARANJA","AZUL",
            "",1))

        colores.add(Colores("AZUL","NARANJA","AMARILLO","ROJO",
            "NEGRO","BEIGE","AMARILLO","NEGRO",
            "ROJO","MORADO","ROJO","MORADO",
            "BEIGE","BEIGE","LILA","VERDE",
            "",1))

        colores.add(Colores("AMARILLO","ROJO","BLANCO","MORADO",
            "ROJO","LILA","MORADO","CAFÉ",
            "MORADO","ROSA","NARANJA","MORADO",
            "NARANJA","CAFÉ","ROJO","AZUL",
            "",1))

        desplegarColores(colores.get(index))

    }


    fun desplegarColores(colores: Colores){

        color1.setText(colores.color1)
        color1.setTextColor(Color.parseColor("#ff0000"))

        color2.setText(colores.color2)
        color2.setTextColor(Color.parseColor("#DCFF00"))

        color3.setText(colores.color3)
        color3.setTextColor(Color.parseColor("#0023FF"))

        color4.setText(colores.color4)
        color4.setTextColor(Color.parseColor("#FF00C5"))

        color5.setText(colores.color5)
        color5.setTextColor(Color.parseColor("#FF8300"))

        color6.setText(colores.color6)
        color6.setTextColor(Color.parseColor("#00FF59"))

        color7.setText(colores.color7)
        color7.setTextColor(Color.parseColor("#FF009E"))

        color8.setText(colores.color8)
        color8.setTextColor(Color.parseColor("#A21BE1"))

        color9.setText(colores.color9)
        color9.setTextColor(Color.parseColor("#000000"))

        color10.setText(colores.color10)
        color10.setTextColor(Color.parseColor("#7A2D2D"))

        color11.setText(colores.color11)
        color11.setTextColor(Color.parseColor("#3C8881"))

        color12.setText(colores.color12)
        color12.setTextColor(Color.parseColor("#173B09"))

        color13.setText(colores.color13)
        color13.setTextColor(Color.parseColor("#B4B4B4"))

        color14.setText(colores.color14)
        color14.setTextColor(Color.parseColor("#693BAB"))

        color15.setText(colores.color15)
        color15.setTextColor(Color.parseColor("#590F63"))

        color16.setText(colores.color16)
        color16.setTextColor(Color.parseColor("#E11B4E"))

        nextColour1.setText(colores.button)
    }

    fun handleAnswer(answerID: Int){

        val nuevoColor=colores.get(index)

        if(nuevoColor.siguienteColor(answerID)){
            Toast.makeText(this, "Siguientes colores", Toast.LENGTH_SHORT).show()
        }
        index++

        if(index >= colores.size){
            var alert= AlertDialog.Builder(this)
            alert.setTitle("Juego finalizado")

            alert.setPositiveButton("Volver al menú"){ dialog: DialogInterface?, which: Int ->
                finish()
            }
            alert.show()
        }else{
            desplegarColores(colores.get(index))
            }
    }

    fun nextColor1(view: View){
        handleAnswer(1)
    }
}