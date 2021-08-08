interface Trie {
    interface Node {
        val char: Char?
        val nodes: HashMap<Char, Node>

        fun addNode(char: Char)
        fun getNode(char: Char): Node
        fun getAllNodes(): List<Node>
        fun containsChar(ch: Char): Boolean
    }
    val root: Node
    fun insert(word: String)
    fun containsWord(word: String): Boolean
    fun autoComplete(word: String): List<String>
}