package countvowelstrings

class CountVowelStrings {
    private val dp: Array<Array<Int>> = Array(51) { Array(6) { -1 } }
    private fun solve(index: Int, vowelNumber: Int): Int {
        if (index == 1) return 1
        if (dp[index][vowelNumber] != -1) return dp[index][vowelNumber]
        for (vowel in vowelNumber..5) {
            dp[index][vowelNumber] += solve(index - 1, vowel)
        }
        return dp[index][vowelNumber]
    }
    fun countVowelStrings(n: Int): Int {
        var answer = 0
        for (vowelNumber in 1..5) {
            answer += solve(n, vowelNumber)
        }
        return answer
    }
}

fun main() {
}
