package nummatchingsubseq

class NumMatchingSubSeq {
    private lateinit var hash: HashMap<Char, MutableList<Int>>
    private var answer = 0
    private fun findLowerBoundGreaterThanThreshold(threshold: Int, char: Char): Int {
        val listOfIndices = hash[char]
        var low = 0
        var high = listOfIndices!!.lastIndex
        var ans = -1
        while (low <= high) {
            val mid = (low + high) / 2
            if (listOfIndices[mid] > threshold) {
                ans = listOfIndices[mid]
                high = mid - 1
            } else { low = mid + 1 }
        }
        return ans
    }

    private fun getIndexFromMainString(character: Char, threshold: Int): Int? {
        if (character !in hash) return null
        return findLowerBoundGreaterThanThreshold(threshold, character).takeIf { it != -1 }
    }

    fun numMatchingSubseq(mainString: String, words: Array<String>): Int {
        hash = HashMap()
        answer = 0
        mainString.forEachIndexed { index, character ->
            if (character !in hash) { hash[character] = mutableListOf() }
            hash[character]?.add(index)
        }
        words.forEach { word ->
            var threshold = -1
            var isPossible = true
            for (char in word) {
                val index = getIndexFromMainString(char, threshold)
                if (index == null) {
                    isPossible = false
                    break
                }
                threshold = index
            }
            if (isPossible) answer++
        }
        return answer
    }
}
