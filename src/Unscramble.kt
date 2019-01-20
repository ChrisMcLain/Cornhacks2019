import org.w3c.dom.*
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document
import kotlin.browser.window

class Unscramble() {

    private var status: Status = Status.IN_PROGRESS
    private val word = spellmate.wordList.getRandomWord()

    private val wordField = document.getElementById("unscrambleWord") as HTMLDivElement
    private val userInput = document.getElementById("unscrambleInput") as HTMLDivElement

    init {
        wordField.innerHTML = word
    }

}