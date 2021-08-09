interface Trie {
    val root: Node
    var count: Int

    fun insert(word: String)
    fun containsWord(word: String): Boolean
    fun autoComplete(word: String): List<String>

    interface Node {
        val char: Char
        val nodes: HashMap<Char, Node>
        var isWord: Boolean

        fun addNode(char: Char)
        fun getNode(char: Char): Node
        fun getAllNodes(): List<Node>
        fun containsChar(ch: Char): Boolean
    }
}