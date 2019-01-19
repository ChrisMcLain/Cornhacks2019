import org.w3c.dom.HTMLInputElement
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    val message = "Hello JavaScript!"
    println(message)

    val testField = document.getElementById("test") as HTMLInputElement
    testField.value = "this works woo"
    testField.addEventListener("click", {
        window.alert("test")
    });
}