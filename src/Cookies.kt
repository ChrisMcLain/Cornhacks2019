const val COOKIE_WORD_LIST = "SPELLMATE_WORD_LIST"

external class Cookies {

    companion object {
        fun set(name: String, value: String)
        fun get(name: String): String?
    }
}