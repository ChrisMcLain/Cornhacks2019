import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
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

    init {

        button1.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(1)
        });

        button2.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(2)
        });

        button3.addEventListener("click", {
            val invisible = !js("\$('#blanksPage').is('.collapse.show')")
            val ended = status != Status.IN_PROGRESS || status == Status.DESTROYED

            if(invisible as Boolean || ended)
                return@addEventListener

            clickOption(3)
        });

        // I'm know there's a better way to condense these three in Java,
        // but it's 1 a.m. and I can't figure out how to do it in Kotlin
    }

    private fun clickOption(i: Int) {
        updateVisuals()
    }

    private fun hasWon(): Boolean {
        return question > GAME_LENGTH;
    }

    private fun updateVisuals() {
        
    }
}