val spellmate: Spellmate = Spellmate()

fun main(args: Array<String>) {
    println("Loaded wordlist of size ${spellmate.wordList.size}\n" + spellmate.wordList.toString())
}