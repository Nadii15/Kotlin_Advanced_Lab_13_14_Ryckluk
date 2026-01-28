data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

interface ProgressPrintable{
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable{
    override val progressText: String
        get() = "${answered} of ${total} answered"

    val question1 = Question<String>(
        "Речка спятила с ума - По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        "Небо зелёное.Правда или ложь",
        false,
        Difficulty.EASY
    )
    val question3 = Question<Int>(
        "Сколько дней между полнолуниями",
        28,
        Difficulty.HARD
    )

    override fun printProgressBar() {
        repeat(Quiz.answered) {print(" ")}
        repeat(Quiz.total - Quiz.answered){ print((" "))}
        println()
        println(progressText)
    }

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}




fun main(){
    println("${Quiz.answered} of ${Quiz.total} answered")
    Quiz().printProgressBar()

    val quiz = Quiz()
    quiz.printQuiz()

    Quiz().apply{printQuiz()}
}

enum class Difficulty{
    EASY,
    MEDIUM,
    HARD
}