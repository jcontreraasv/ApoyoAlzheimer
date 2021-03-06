package jaime.contreras.apoyoalzheimer.juegos

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R
import jaime.contreras.apoyoalzheimer.inicio.BienvenidoActivity
import kotlinx.android.synthetic.main.activity_juego_examen.*

class JuegoExamenActivity : AppCompatActivity() {

    var quiz2 = ArrayList<Examen>()
    var respuestasCorrectas: Int=0
    var currentQuizIndex: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_examen)

        var alert= AlertDialog.Builder(this)

        alert.setTitle("INSTRUCCIONES")
        alert.setMessage("El objetivo de este ejercicio es resolver una serie de preguntas" +
                "        seleccionando cierto (botón correcto) o falso(botón cruz) segun corresponda.")
        alert.setPositiveButton("Iniciar",{ dialog: DialogInterface?, which: Int -> })
        alert.show()

        quiz2.add(Examen("¿Estamos en el mes de mayo?","","",1))
        quiz2.add(Examen("¿Estamos en Ciudad Obregón?","","",1))
        quiz2.add(Examen("¿La capital de Corea del Norte es Seúl?","","",2))
        quiz2.add(Examen("Colombia limita con Ecuador, Surinam, Bolivia y Perú", "","",2))
        quiz2.add(Examen("Cerca de un 20 % de la población mundial es musulmana", "","",1))
        quiz2.add(Examen("El cerebro es el órgano más pesado del cuerpo humano", "","",1))
        quiz2.add(Examen("Más del 50 % de la mortalidad infantil se debe al problema del hambre mundial.", "","",1))
        quiz2.add(Examen("La phobofobia es la fobia a la filosofía", "","",2))
        quiz2.add(Examen("La longitud del Río Nilo es de 6650 kilómetros", "","",1))
        quiz2.add(Examen("La entomología es la ciencia que estudia el desarrollo de los organismos unicelulares", "","",2))

        mostrarPregunta(quiz2.get(currentQuizIndex))
    }

    fun mostrarPregunta(examen: Examen){
        pregunta.setText(examen.question)
        boton_quiz_correcto.setText(examen.answer1)
        boton_quiz_incorrecto.setText(examen.answer2)
    }

    fun handleAnswer(answerID: Int){

        val quiz=quiz2.get(currentQuizIndex)

        if(quiz.isCorrect(answerID)){
            respuestasCorrectas++
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show()
        }
        currentQuizIndex++

        if(currentQuizIndex >= quiz2.size){

            var alert= AlertDialog.Builder(this)
            alert.setTitle("Juego finalizado.")
            alert.setMessage("Obtuvo " + respuestasCorrectas + " aciertos.")
            alert.setPositiveButton("Volver al menu"){ dialog: DialogInterface?, which: Int ->
                finish()
            }
            alert.show()

        }else{
            mostrarPregunta(quiz2.get(currentQuizIndex))
        }
    }

    fun correcto(view: View){
        handleAnswer(1)
    }

    fun incorrecto(view: View){
        handleAnswer(2)
    }
}
