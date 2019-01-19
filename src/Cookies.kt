import org.w3c.dom.url.URL
import kotlin.browser.window

const val COOKIE_WORD_LIST = "SPELLMATE_WORD_LIST"

external class Cookies {

    companion object {
        fun set(name: String, value: String)
        fun get(name: String): String?
    }
}

const val PARAM_WORD_LIST = "sm_wl"

class Parameters {

    companion object {
        fun get(name: String): String? {
            val url = URL(window.location.href)
            return url.searchParams.get(name)
        }
    }
}