import org.w3c.dom.HTMLInputElement
import kotlin.browser.document

fun main(args: Array<String>) {
    val message = "Hello JavaScript!"
    println(message)

    val testField = document.getElementById("test") as HTMLInputElement
    testField.value = "this works woo"
}