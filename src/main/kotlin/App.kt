import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    console.log("Hello, ${greet()}")
    val input = document.getElementById("input") as HTMLInputElement
    val result = document.getElementById("result") as HTMLTextAreaElement

    input.addEventListener("input", {
        if(input.value.isEmpty()) {
            result.style.display = "none"
            input.classList.remove("input-not-empty")
            input.classList.add("input-empty")
        } else {
            result.style.display = "block"
            input.classList.remove("input-empty")
            input.classList.add("input-not-empty")
        }
    })
}

fun greet() = "world"