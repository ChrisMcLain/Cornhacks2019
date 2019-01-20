import org.w3c.dom.*
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document
import kotlin.browser.window

class Unscramble() {

    private var status: Status = Status.IN_PROGRESS
    private var word = spellmate.wordList.getRandomWord()
    private var shuffled = word.toList().shuffled().joinToString(" ")
    private var guess = ""
    private var counter = 0

    private val wordField = document.getElementById("unscrambleWord") as HTMLDivElement
    private val counterField = document.getElementById("unscrambleCounter") as HTMLDivElement
    private val userInput = document.getElementById("unscrambleInput") as HTMLInputElement

    init {
        userInput.addEventListener("input", {
            guess = userInput.value

            if(guess.equals(word)) {
                reset()
            }

            updateVisuals();
        })

        updateVisuals()
    }

    private fun updateVisuals() {
        wordField.innerText = shuffled
        counterField.innerText = "$counter word(s) unscrambled."
    }

    private fun reset() {
        userInput.value = ""
        word = spellmate.wordList.getRandomWord()
        shuffled = word.toList().shuffled().joinToString(" ")
        counter++
    }
}