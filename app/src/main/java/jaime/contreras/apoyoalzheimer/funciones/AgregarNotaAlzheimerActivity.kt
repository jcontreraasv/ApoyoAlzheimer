package jaime.contreras.apoyoalzheimer.funciones

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_agregar_nota_alzheimer.*
import kotlinx.android.synthetic.main.activity_nota_alzheimer.*
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception


class AgregarNotaAlzheimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_nota_alzheimer)

        btn_guardarNotaAlz.setOnClickListener{
            registrarNotaAlz()
        }
    }

    fun registrarNotaAlz() {
        //verifica que tenga los permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //si no los tiene, los pide al usuario
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 235)
            //si tiene permisos procede a guardar
        } else {
            registrar()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            255 -> {
                //pregunta si el usuario aceptó los permisos
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    registrar()
                } else {
                    //si no aceptó, coloca un mensaje
                    Toast.makeText(this, "Error: permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    public fun registrar(){

        var titulo = tituloNota_Alz.text.toString()
        var cuerpo = contenidoNota_Alz.text.toString()

        if(titulo == "" || cuerpo == ""){
            Toast.makeText(this, "Error: campos vacíos", Toast.LENGTH_SHORT).show()
        }else{
            try{

                val archivo = File(ubicacion(), titulo + ".txt")
                val fos = FileOutputStream(archivo)

                fos.write(cuerpo.toByteArray())
                fos.close()
                Toast.makeText(this, "se guardó el archivo en la carpeta pública", Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                Toast.makeText(this, "Error: no se guardó el archivo", Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    private fun ubicacion(): String{
        val carpeta = File(Environment.getExternalStorageDirectory(), "consejosAlz")
        if(!carpeta.exists()){
            carpeta.mkdir()
        }
        return carpeta.absolutePath
    }
}
