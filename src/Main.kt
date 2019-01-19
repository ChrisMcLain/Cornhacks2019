import org.w3c.dom.HTMLTextAreaElement
import kotlin.browser.document

val spellmate: Spellmate = Spellmate()

fun main(args: Array<String>) {
    println("Loaded wordlist of size ${spellmate.wordList.size}\n" + spellmate.wordList.toString())

    val wordList = document.getElementById("teacherTextArea") as HTMLTextAreaElement;
    spellmate.wordList.wordList.forEach { n ->
        run {
            wordList.textContent += n + "\n"
        }
    }
    wordList.textContent = wordList.textContent?.trim()
}