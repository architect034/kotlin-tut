package isaliensorted

class IsAlienSorted {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val orderMap = IntArray(26)
        for (i in order.indices) {
            orderMap[order[i] - 'a'] = i
        }
        for (i in 0 until words.size - 1) {
            for (j in words[i].indices) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length) return false
                if (words[i][j] != words[i + 1][j]) {
                    val currentWordChar = words[i][j] - 'a'
                    val nextWordChar = words[i + 1][j] - 'a'
                    return if (orderMap[currentWordChar] > orderMap[nextWordChar]) false else break
                }
            }
        }
        return true
    }
}
