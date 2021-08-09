class TrieImpl: Trie {
    override val root: Trie.Node = NodeImpl('/')
    override var count: Int = 0

    override fun insert(word: String) {
        var currentNode = root
        for ((index, ch) in word.withIndex()) {
            if(!currentNode.containsChar(ch)) {
                currentNode.addNode(ch)
            }
            currentNode = currentNode.getNode(ch)
            if(index == word.lastIndex) {
                currentNode.isWord = true
                count++
            }
        }
    }

    override fun containsWord(word: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun autoComplete(word: String): List<String> {
        if(word.isEmpty()) return emptyList()

        val words = ArrayList<String>()

        var currentNode = root
        for(ch in word) {
            if(!currentNode.containsChar(ch)) {
                return words
            }
            currentNode = currentNode.getNode(ch)
        }

        autocompleteHelper(currentNode, word, words)
        return words
    }

    private fun autocompleteHelper(node: Trie.Node, word: String, list: ArrayList<String>) {
        if(node.getAllNodes().isEmpty()) {
            return
        }
        for(childNode in node.getAllNodes()) {
            if(childNode.isWord) {
                list.add(word + childNode.char)
            }
            autocompleteHelper(childNode, word + childNode.char, list)
        }
    }

    private class NodeImpl(override val char: Char): Trie.Node {

        override val nodes = HashMap<Char, Trie.Node>()
        override var isWord = false

        override fun addNode(char: Char) {
            nodes[char] = NodeImpl(char)
        }

        override fun getNode(char: Char): Trie.Node {
            return nodes[char]!!
        }

        override fun getAllNodes(): List<Trie.Node> {
            return nodes.values.toList()
        }

        override fun containsChar(ch: Char): Boolean {
            return nodes.containsKey(ch)
        }

    }
}