package jaime.contreras.apoyoalzheimer.PRUEBAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import jaime.contreras.apoyoalzheimer.R

class QuizActivity : AppCompatActivity() {

    /*
    private var puntajeV: TextView? = null
    private var preguntaV: TextView? = null
    private var cierto: Button? = null
    private var falso: Button? = null
    private var respuesta: Boolean? = null
    private var puntaje = 0
    private var pregunta = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_examen)
        
        puntajeV = findViewById<View>(R.id.puntos) as TextView
        preguntaV = findViewById<View>(R.id.pregunta) as TextView
        cierto = findViewById<View>(R.id.boton_quiz_correcto) as Button
        falso = findViewById<View>(R.id.boton_quiz_incorrecto) as Button


        //cierto
        cierto!!.setOnClickListener {
            //PREGUNTA CORRECTA
            if (respuesta == true) {
                puntaje++
                actualizarPuntaje(puntaje)

                if (pregunta == PreguntasQuiz) {
                    val i = Intent(this@QuizActivity, ResultadosActivity::class.java)
                    val bundle = Bundle()
                    bundle.putInt("Puntaje final", puntaje)
                    i.putExtras(bundle)
                    finish()
                    startActivity(i)
                } else {
                    actualizarPregunta()
                }
            } else {
                if (pregunta == PreguntasQuiz.respuestas.length) {
                    val i = Intent(this@QuizActivity, ResultadosActivity::class.java)
                    val bundle = Bundle()
                    bundle.putInt("Puntaje final", puntaje)
                    i.putExtras(bundle)
                    finish()
                    startActivity(i)
                } else {
                    actualizarPregunta()
                }
            }
        }

        //falso
        falso!!.setOnClickListener { //PREGUNTA CORRECTA
            if (respuesta == false) {
                puntaje++
                actualizarPuntaje(puntaje)
                if (pregunta == PreguntasQuiz.respuestas.length) {
                    val i = Intent(this@QuizActivity, ResultadosActivity::class.java)
                    val bundle = Bundle()
                    bundle.putInt("Puntaje final", puntaje)
                    i.putExtras(bundle)
                    finish()
                    startActivity(i)
                } else {
                    actualizarPregunta()
                }
            } else {
                if (pregunta == PreguntasQuiz.respuestas.length) {
                    val i = Intent(this@QuizActivity, ResultadosActivity::class.java)
                    val bundle = Bundle()
                    bundle.putInt("Puntaje final", puntaje)
                    i.putExtras(bundle)
                    finish()
                    startActivity(i)
                } else {
                    actualizarPregunta()
                }
            }
        }
    }

    private fun actualizarPregunta() {
        preguntaV!!.text = PreguntasQuiz.preguntas[pregunta]
        respuesta = PreguntasQuiz.respuestas[pregunta]
        pregunta++
    }

    fun actualizarPuntaje(puntos: Int) {
        puntajeV!!.text = "" + puntaje
    }

     */
}