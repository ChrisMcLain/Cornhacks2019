import org.w3c.dom.*
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.browser.window

val spellmate: Spellmate = Spellmate()
var hangman: Hangman = Hangman()
var blanks: Blanks = Blanks()

fun main(args: Array<String>) {
    println("Loaded wordlist of size ${spellmate.wordList.size}\n" + spellmate.wordList.toString())

    //Teacher's Page things
    val wordList = document.getElementById("teacherTextArea") as HTMLTextAreaElement;
    spellmate.wordList.wordList.forEach { n ->
        run {
            wordList.textContent += n + "\n"
        }
    }
    wordList.textContent = wordList.textContent?.trim()

    val generateButton = document.getElementById("teacherButton") as HTMLButtonElement
    val modalButton = document.getElementsByName("teacherButtonDone").asList()
    val generateLink = document.getElementById("teacherUrl") as HTMLInputElement
    val generateTextArea = document.getElementById("teacherTextArea") as HTMLTextAreaElement
    generateButton.addEventListener("click", {
        spellmate.wordList = WordList(generateTextArea.value)
        generateLink.value = spellmate.wordList.getLink();
    })
    modalButton.forEach { n -> n.addEventListener("click", {
        window.location.assign(spellmate.wordList.getLink());
    })}
}

fun resetHangman() {
    println("Reset Hangman Game")
    hangman = Hangman()
}

fun resetBlanks() {
    println("Reset Blanks Game")
    blanks = Blanks()
}