import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.window

class Hangman() {

    val gameOver = false
    val word = spellmate.wordList.getRandomWord();
    val guesses = mutableListOf<Char>()
    val incorrectGuesses = mutableListOf<Char>()

    init {
        window.addEventListener("keydown", { n ->
            val event = n as KeyboardEvent
            val letter = event.key.toLowerCase()
            val modifiers = event.altKey || event.ctrlKey || event.shiftKey
            val char = letter.single()

            if(modifiers || guesses.contains(char) || gameOver)
                return@addEventListener

            if(letter.matches("[A-Za-z]"))
                tryPlayLetter(char)
        })
    }

    fun tryPlayLetter(letter: Char) {
        guesses.add(letter)

        if(!isCorrectGuess(letter)) {
            incorrectGuesses.add(letter)
        }

        updateVisuals()
    }

    fun isCorrectGuess(letter: Char): Boolean {
        return word.contains(letter)
    }

    private fun updateVisuals() {
        TODO("not implemented yeet")
    }
}