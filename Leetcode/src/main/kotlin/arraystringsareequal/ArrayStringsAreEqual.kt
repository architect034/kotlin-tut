package arraystringsareequal

class ArrayStringsAreEqual {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val strA: MutableList<Char> = mutableListOf()
        val strB: MutableList<Char> = mutableListOf()
        for (str in word1) {
            for (ch in str) {
                strA.add(ch)
            }
        }
        for (str in word2) {
            for (ch in str) {
                strB.add(ch)
            }
        }
        if (strA == strB) {
            return true
        }
        return false
    }
}
