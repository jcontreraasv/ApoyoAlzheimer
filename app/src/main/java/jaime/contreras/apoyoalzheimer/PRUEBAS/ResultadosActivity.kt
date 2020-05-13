package jaime.contreras.apoyoalzheimer.PRUEBAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import jaime.contreras.apoyoalzheimer.R
import jaime.contreras.apoyoalzheimer.juegos.MenuJuegosActivity

class ResultadosActivity : AppCompatActivity() {
    /*
    var calificacion: TextView? = null
    var resFinal: TextView? = null
    var retry: Button? = null
    var menu: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_examen_final)

        calificacion = findViewById<View>(R.id.calificacion) as TextView
        resFinal = findViewById<View>(R.id.puntajeFinal) as TextView
        retry = findViewById<View>(R.id.boton_volver_juego_examen) as Button
        menu = findViewById<View>(R.id.boton_volver_menu) as Button

        val bundle = intent.extras
        val puntuacion = bundle!!.getInt("Puntaje final")

        resFinal!!.text = "Obtuviste " + puntuacion + " de" + PreguntasQuiz.preguntas.length

        if (puntuacion == 3) {
            calificacion!!.text = "Excelente"
        } else if (puntuacion == 2) {
            calificacion!!.text = "Bien!"
        } else if (puntuacion == 1) {
            calificacion!!.text = "Regular"
        } else if (puntuacion == 0) {
            calificacion!!.text = "Reprobado"
        }
        retry!!.setOnClickListener {
            startActivity(Intent(this@ResultadosActivity, QuizActivity::class.java))
            finish()
        }
        menu!!.setOnClickListener {
            startActivity(Intent(this@ResultadosActivity, MenuJuegosActivity::class.java))
            finish()
        }
    }

     */
}