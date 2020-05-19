package jaime.contreras.apoyoalzheimer.funciones

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_menu_consejos.*

class MenuConsejosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_consejos)

        var alert= AlertDialog.Builder(this)
        alert.setTitle("INSTRUCCIONES")
        alert.setMessage("En este apartado podrá añadir consejos o notas según la opción que seleccione.\n" +
                "Si selecciona la opción Consejos, podrá añadir consejos que serán registrados para su paciente, el cual podrá leerlos.\n" +
                "Si selecciona la opción Alzheimer, podrá añadir notas o datos sobre la enfermedad que serán registradas para su paciente, el cual podrá leerlos")
        alert.setPositiveButton("Iniciar",{ dialog: DialogInterface?, which: Int -> })
        alert.show()

        var intento0: Intent = Intent(this, MainConsejosUsuarioActivity::class.java)
        var intento1: Intent = Intent(this, MainNotasAlzheimerActivity::class.java)

        consejos_btn_usuario.setOnClickListener{
            startActivity(intento0)
        }

        consejos_btn_alzheimer.setOnClickListener{
            startActivity(intento1)
        }
    }
}
