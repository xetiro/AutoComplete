object Provider {

    fun provideTrie(): Trie = TrieImpl()

    fun provideWords(): List<String> {
        val words = content.split("\\s+".toRegex()).map { word ->
            word.replace("""^[,\.]|[,\.]$""".toRegex(), "")
        }
        return words;
    }

    // Do insert a concatenation of text here and use it to load on the trie
    private const val content: String = ""
}