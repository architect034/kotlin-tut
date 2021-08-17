package closestrings

class CloseStrings {
    fun closeStrings(word1: String, word2: String): Boolean {
        val hashMap: MutableMap<Char, Int> = mutableMapOf()
        for (char in word1) {
            hashMap[char] = hashMap.getOrDefault(char, 0) + 1
        }
        val valuesOfFirst = mutableListOf<Int>()
        val keysOfFirst = mutableListOf<Char>()
        hashMap.forEach {
            valuesOfFirst.add(it.value)
            keysOfFirst.add(it.key)
        }
        valuesOfFirst.sort()
        keysOfFirst.sort()
        hashMap.clear()
        for (char in word2) {
            hashMap[char] = hashMap.getOrDefault(char, 0) + 1
        }
        val valuesOfSecond = mutableListOf<Int>()
        val keysOfSecond = mutableListOf<Char>()
        hashMap.forEach {
            valuesOfSecond.add(it.value)
            keysOfSecond.add(it.key)
        }
        valuesOfSecond.sort()
        keysOfSecond.sort()
        if (valuesOfFirst == valuesOfSecond && keysOfFirst == keysOfSecond) {
            return true
        }
        return false
    }
}

fun main() {
    CloseStrings().closeStrings("abc", "a")
}
