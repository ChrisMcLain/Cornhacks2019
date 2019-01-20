import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document
import kotlin.browser.window

class Hangman() {

    enum class Status {
        IN_PROGRESS,
        WIN,
        LOSE
    }

    private var status: Status = Status.IN_PROGRESS
    private val word = spellmate.wordList.getRandomWord();
    private val guesses = mutableListOf<Char>()
    private val incorrectGuesses = mutableListOf<Char>()

    private val hangman = document.getElementById("theHangman") as HTMLImageElement
    private val guessBox = document.getElementById("hangmanGuessBox") as HTMLDivElement
    private val wordBox = document.getElementById("hangmanWordBox") as HTMLDivElement

    init {
        window.addEventListener("keydown", { n ->
            val event = n as KeyboardEvent
            val letter = event.key.toLowerCase()
            val modifiers = event.altKey || event.ctrlKey || event.shiftKey
            val char = letter.single()

            if(modifiers || guesses.contains(char) || status != Status.IN_PROGRESS)
                return@addEventListener

            if(letter.matches("[A-Za-z]"))
                tryPlayLetter(char)
        })
    }

    private fun tryPlayLetter(letter: Char) {
        guesses.add(letter)

        if(!isCorrectGuess(letter)) {
            incorrectGuesses.add(letter)
        }

        if(incorrectGuesses.size >= 9) {
            status = Status.LOSE;
        } else if(hasWon()) {
            status = Status.WIN;
        }

        updateVisuals()
    }

    private fun hasWon(): Boolean {
        word.forEach { n ->
            if(!guesses.contains(n)) {
                return false;
            }
        }
        return true;
    }

    fun isCorrectGuess(letter: Char): Boolean {
        return word.contains(letter)
    }

    private fun updateVisuals() {
        hangman.src = "Images/Hangman%200" + incorrectGuesses.size + ".png"
        guessBox.innerHTML = incorrectGuesses.joinToString("", "<h1 class=\"hangman_letter\">", "</h1>")
    }
}