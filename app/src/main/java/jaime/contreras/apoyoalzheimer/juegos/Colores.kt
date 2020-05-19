package jaime.contreras.apoyoalzheimer.juegos

class Colores(var color1: String,var color2: String,var color3: String,var color4: String,
              var color5: String,var color6: String,var color7: String,var color8:String,
              var color9: String,var color10: String,var color11: String,var color12:String,
              var color13: String,var color14: String,var color15: String,var color16:String,
              var button:String,var nextColor: Int){

    fun siguienteColor(siguientesColores: Int) : Boolean {
        if (siguientesColores == nextColor)
            return true

        return false
    }
}



