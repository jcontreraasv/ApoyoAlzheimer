package jaime.contreras.apoyoalzheimer.juegos

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_juego_operaciones.*

class JuegoOperacionesActivity : AppCompatActivity() {

    var quiz1 = ArrayList<Operaciones>()
    var respuestasCorrectas: Int=0
    var currentQuizIndex: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_operaciones)

        quiz1.add(Operaciones("5 x 5 = ?","25","20","30","35",1))
        quiz1.add(Operaciones("9 x 8 = ?","80","70","72","74",3))
        quiz1.add(Operaciones("6 x 7 = ?","38","42","44","40",2))

        mostrarPregunta(quiz1.get(currentQuizIndex))
    }

    fun mostrarPregunta(operaciones: Operaciones){
        operacion.setText(operaciones.question)
        opcionesOperaciones1.setText(operaciones.answer1)
        opcionesOperaciones2.setText(operaciones.answer2)
        opcionesOperaciones3.setText(operaciones.answer3)
        opcionesOperaciones4.setText(operaciones.answer4)
    }

    fun handleAnswer(answerID: Int){

        val quiz=quiz1.get(currentQuizIndex)

        if(quiz.isCorrect(answerID)){
            respuestasCorrectas++
            Toast.makeText(this, "Correcto!",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Incorrecto!",Toast.LENGTH_SHORT).show()
        }
        currentQuizIndex++

        if(currentQuizIndex >= quiz1.size){
            var alert= AlertDialog.Builder(this)
            alert.setTitle("Juego finalizado.")
            alert.setMessage("Tuviste " + respuestasCorrectas + " aciertos.")
            alert.setPositiveButton("Continuar"){ dialog: DialogInterface?, which: Int ->
                finish()
            }
            alert.show()
        }else{
            mostrarPregunta(quiz1.get(currentQuizIndex))
        }
    }

    fun boton1(view: View){
        handleAnswer(1)
    }

    fun boton2(view: View){
        handleAnswer(2)
    }

    fun boton3(view: View){
        handleAnswer(3)
    }

    fun boton4(view: View){
        handleAnswer(4)
    }
}
