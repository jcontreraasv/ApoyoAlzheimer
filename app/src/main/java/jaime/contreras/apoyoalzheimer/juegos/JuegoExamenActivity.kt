package jaime.contreras.apoyoalzheimer.juegos

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_juego_examen.*
import kotlinx.android.synthetic.main.activity_juego_operaciones.*

class JuegoExamenActivity : AppCompatActivity() {

    var quiz2 = ArrayList<Examen>()
    var respuestasCorrectas: Int=0
    var currentQuizIndex: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_examen)

        val dialog=AlertDialog.Builder(this)
        val dialogView=layoutInflater.inflate(R.layout.activity_juego_examen_dialog,null)

        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
        dialog.show()

        quiz2.add(Examen("¿Estamos en el mes de mayo?","","",1))
        quiz2.add(Examen("¿Estamos en Ciudad Obregón?","","",1))
        quiz2.add(Examen("¿La capital de Corea del Norte es Seúl?","","",2))

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
            alert.setMessage("Tuviste " + respuestasCorrectas + " aciertos.")
            alert.setPositiveButton("Continuar"){ dialog: DialogInterface?, which: Int ->
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
