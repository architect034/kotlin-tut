package longestpalindrome

class LongestPalindrome {
    private val dp: Array<Array<Boolean>> = Array(1000) { Array(1000) { false } }
    fun longestPalindrome(s: String): String {
        var range: Pair<Int, Int> = Pair(0, 0)
        val n = s.length
        for (i in 0 until n) {
            dp[i][i] = true
            range = Pair(i, i)
        }
        for (i in 0 until n - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                range = Pair(i, i + 1)
            }
        }
        for (i in 3..n) {
            for (j in 0..n - i) {
                if (s[j] == s[j + i - 1] && dp[j + 1][j + i - 2]) {
                    dp[j][j + i - 1] = true
                    range = Pair(j, j + i - 1)
                }
            }
        }
        return s.substring(range.first, range.second + 1)
    }
}
