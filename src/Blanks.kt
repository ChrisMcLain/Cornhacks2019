import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.asList
import kotlin.browser.document

class Blanks() {

    companion object {
        val GAME_LENGTH = 5;
    }

    private var status: Status = Status.IN_PROGRESS
    private val questions: List<Question> = spellmate.questionList.take()
    private var question = 0

    private val sentenceBox = document.getElementById("blanksSentence") as HTMLDivElement
    private val button1 = document.getElementById("blanksButton1") as HTMLButtonElement
    private val button2 = document.getElementById("blanksButton2") as HTMLButtonElement
    private val button3 = document.getElementById("blanksButton3") as HTMLButtonElement
    private val winBoxText = document.getElementById("blanksWinBoxText") as HTMLDivElement
    private val loseBoxText = document.getElementById("blanksLoseBoxText") as HTMLDivElement
    private val tryAgainButton = document.getElementsByName("blanksTryAgainButton").asList()

    init {

        button1.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(0)
        });

        button2.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(1)
        });

        button3.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(2)
        });

        // I'm know there's a better way to condense these three in Java,
        // but it's 1 a.m. and I can't figure out how to do it in Kotlin

        tryAgainButton.forEach { n -> n.addEventListener("click", {
            if(status != Status.DESTROYED) {
                status = Status.DESTROYED
                resetBlanks()
            }
        })}
    }

    private fun clickOption(i: Int) {
        if(getQuestion().getCorrectAnswerIndex() == i) {
            question++

            if(hasWon()) {
                status = Status.WIN
            }
        } else {
            status = Status.LOSE
        }

        updateVisuals()
    }

    private fun getQuestion(): Question {
        return questions[question]
    }

    private fun hasWon(): Boolean {
        return question > GAME_LENGTH;
    }

    private fun updateVisuals() {
        sentenceBox.innerText = getQuestion().getBlankedQuestion()

        if(status == Status.WIN) {
            winBoxText.innerText = "You answered all $question questions correctly."
            js("\$('#blanksWinBox').modal()")
        } else if(status == Status.LOSE) {
            loseBoxText.innerText = "You answered only $question questions correctly."
            js("\$('#blanksLoseBox').modal()")
        }
    }
}