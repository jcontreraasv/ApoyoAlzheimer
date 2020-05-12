package jaime.contreras.apoyoalzheimer

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class JuegoSecuenciaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_secuencia)

        val dialog= AlertDialog.Builder(this)
        val dialogView=layoutInflater.inflate(R.layout.activity_juego_secuencia_dialog,null)

        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
        dialog.show()
    }
}
