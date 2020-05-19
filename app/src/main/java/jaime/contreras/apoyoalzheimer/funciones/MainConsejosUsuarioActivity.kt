package jaime.contreras.apoyoalzheimer.funciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_main_consejos_usuario.*
import java.io.*

class MainConsejosUsuarioActivity : AppCompatActivity() {

    var consejos = ArrayList<Consejo>()
    lateinit var adaptador: AdaptadorConsejosUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_consejos_usuario)

        agregarConsejoUsuario.setOnClickListener{
            var intent = Intent(this, AgregarConsejoActivity::class.java)
            startActivityForResult(intent, 123)
        }

        adaptador =  AdaptadorConsejosUsuario(this, consejos)
        listaConsejosUsuario.adapter = adaptador
    }

    fun leerConsejos(){

        consejos.clear()
        var carpeta = File(ubicacion().absolutePath)

        if(carpeta.exists()){

            var archivos = carpeta.listFiles()

            if(archivos !=null){
                for (archivo in archivos){
                    leerArchivo(archivo)
                }
            }
        }
    }

    fun leerArchivo(archivo: File){
        val fis = FileInputStream(archivo)
        val di = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(di))
        var strLine: String? = br.readLine()
        var myData = ""

        //lee los archivos almacenados en la memoria
        while(strLine != null ){
            myData = myData + strLine
            strLine = br.readLine()
        }

        br.close()
        di.close()
        fis.close()
        //elimina el .txt
        var nombre = archivo.name.substring(0, archivo.name.length-4)
        //crea la nota y la agrega a la lista
        var cons = Consejo(nombre, myData)
        consejos.add(cons)
    }

    private fun ubicacion(): File{
        val folder = File(Environment.getExternalStorageDirectory(), "consejosUsuario")
        if(!folder.exists()){
            folder.mkdir()
        }
        return folder
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // se activa cuando regresa del AgregarNotaActivity
        if(requestCode == 123){
            leerConsejos()
            adaptador.notifyDataSetChanged()
        }
    }
}
