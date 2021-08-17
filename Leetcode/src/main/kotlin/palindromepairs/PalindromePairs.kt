package palindromepairs

class PalindromePairs {
    private fun isPalindrome(word1: String, word2: String): Boolean {
        val word = word1 + word2
        val len = word.length
        for (i in 0 until len / 2) {
            if (word[i] != word[len - 1 - i]) return false
        }
        return true
    }
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        words.forEachIndexed { i, word1 ->
            words.forEachIndexed { j, word2 ->
                if (i == j) return@forEachIndexed
                if (isPalindrome(word1, word2)) {
                    ans.add(mutableListOf(i, j))
                }
            }
        }
        return ans
    }
}
