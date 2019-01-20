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
        

        tryAgainButton.forEach { n -> n.addEventListener("click", {
            if(status != Status.DESTROYED) {
                status = Status.DESTROYED
                resetBlanks()
            }
        })}

        updateVisuals()
    }

    private fun clickOption(i: Int) {
        if(getQuestion().getCorrectAnswerIndex() == i) {
            question++

            if(hasWon()) {
                status = Status.WIN
                question = 0;
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
        return question >= GAME_LENGTH;
    }

    private fun updateVisuals() {
        sentenceBox.innerHTML = "<small>Question ${question + 1} of $GAME_LENGTH</small><br/>${getQuestion().getBlankedQuestion()}"

        val answers = getQuestion().getChoices()

        button1.innerText = answers[0]
        button2.innerText = answers[1]

        if(answers.size > 2) {
            button3.innerText = answers[2]
            button3.disabled = false
        } else {
            button3.innerText = "N/A"
            button3.disabled = true
        }

        if(status == Status.WIN) {
            winBoxText.innerText = "You answered all $GAME_LENGTH questions correctly."
            js("\$('#blanksWinBox').modal()")
        } else if(status == Status.LOSE) {
            loseBoxText.innerText = "You answered $question question(s) correctly."
            js("\$('#blanksLoseBox').modal()")
        }
    }
}