package LengthOfLongestSubstring

import kotlin.math.max

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var ans = 0
        val length = s.length
        val hash: Array<Int> = Array(150) { 0 }
        var st = 0
        var end = 0
        while (true) {
            var say: Boolean = true
            for (i in hash) {
                if (i > 1) {
                    say = false
                    break
                }
            }
            if (say) {
                ans = max(ans, end - st + 1)
                end++
                if (end < length) {
                    hash[s[end].toInt()]++
                } else {
                    break
                }
            } else {
                hash[s[st].toInt()]--
                st++
            }
        }
        return ans
    }
}
