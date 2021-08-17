package isanagram

class IsAnagram {
    private val hash: IntArray = IntArray(26) { 0 }
    fun isAnagram(s: String, t: String): Boolean {
        for (char in s) {
            hash[char - 'a']++
        }
        for (char in t) {
            hash[char - 'a']--
        }
        return !hash.any {
            it != 0
        }
    }
}
