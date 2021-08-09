import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement

lateinit var trie: Trie
lateinit var resultTextArea: HTMLTextAreaElement

fun main() {
    trie = Provider.provideTrie()
    populateTrie()

    val count = document.getElementById("count") as HTMLDivElement
    count.textContent = "Auto-Complete for ${trie.count} words"

    resultTextArea = document.getElementById("result") as HTMLTextAreaElement

    val input = document.getElementById("input") as HTMLInputElement
    input.addEventListener("input", {
        if(input.value.isEmpty()) {
            input.classList.remove("input-not-empty")
            input.classList.add("input-empty")
            resultTextArea.style.display = "none"
        } else {
            handleInput(input.value)
            if(resultTextArea.value.isNotEmpty()) {
                input.classList.remove("input-empty")
                input.classList.add("input-not-empty")
                resultTextArea.style.display = "block"
            }
        }
    })
}

fun populateTrie() {
    // fill up the Trie
    val allWords: List<String> = Provider.provideWords()
    allWords.forEach { word -> trie.insert(word) }
}

fun handleInput(word: String) {
    val result = trie.autoComplete(word)
    updateResult(result)
}

fun updateResult(result: List<String>) {
    resultTextArea.value = ""   // clear
    for(word in result) {
        resultTextArea.value += word + "\n"
    }
}