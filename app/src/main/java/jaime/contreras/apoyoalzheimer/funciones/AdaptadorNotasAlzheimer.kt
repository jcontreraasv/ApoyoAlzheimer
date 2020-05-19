package jaime.contreras.apoyoalzheimer.funciones

import android.content.Context
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_nota_alzheimer.view.*
import java.io.File
import java.lang.Exception

class AdaptadorNotasAlzheimer : BaseAdapter {

    var context: Context
    var consejos = ArrayList<Nota>()

    constructor(context: Context, notas: ArrayList<Nota>){
        this.context=context
        this.consejos=notas
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.activity_nota_alzheimer, null)
        var consejo = consejos[position]

        vista.titulo_nota_alzheimer.text = consejo.titulo
        vista.contenido_nota_alzheimer.text = consejo.consejo

        vista.btn_borrar_nota_alzheimer.setOnClickListener{
            eliminar(consejo.titulo)
            consejos.remove(consejo)
            this.notifyDataSetChanged()
        }
        return vista
    }

    private fun eliminar(titulo: String){
        if (titulo == ""){
            Toast.makeText(context, "Error: Título vacio.", Toast.LENGTH_SHORT).show()
        }else{
            try{
                //elimina el archivo con el titulo seleccionado
                val archivo = File(ubicacion(), titulo+".txt")
                archivo.delete()

                Toast.makeText(context, "Se eliminó el archivo", Toast.LENGTH_SHORT).show()
            }catch(e: Exception){
                Toast.makeText(context, "Error al eliminar el archivo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ubicacion(): String{
        val album = File(Environment.getExternalStorageDirectory(), "consejosAlz")
        if(!album.exists()){
            album.mkdir()
        }
        return album.absolutePath
    }

    override fun getItem(position: Int): Any {
        return consejos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return consejos.size
    }
}
