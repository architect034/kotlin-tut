package shortesttochar

import kotlin.math.min

class ShortestToChar {
    fun shortestToChar(s: String, c: Char): IntArray {
        val len = s.length
        var answer = IntArray(len) { 0 }
        val hash = IntArray(len) { 0 }
        var last = Int.MAX_VALUE / 2
        for (index in len - 1 downTo 0) {
            if (s[index] == c) {
                last = index
            }
            hash[index] = last
        }
        last = Int.MIN_VALUE / 2
        for (index in 0 until len) {
            if (s[index] == c) {
                last = index
            }
            answer[index] = min(index - last, hash[index] - index)
        }
        return answer
    }
}
