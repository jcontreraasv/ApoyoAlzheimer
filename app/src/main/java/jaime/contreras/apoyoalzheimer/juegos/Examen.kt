package jaime.contreras.apoyoalzheimer.juegos

class Examen(var question:String, var answer1:String, var answer2: String,var correctAnswerNumber: Int) {

    fun isCorrect(answerNumber: Int) : Boolean{
        if (answerNumber == correctAnswerNumber)
            return true

        return false
    }
}