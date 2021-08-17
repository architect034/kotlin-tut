package numdecodings
class NumDecodings {
    private val dp = Array(100) { Array<Int>(1000) { _ -> -1 } }
    private fun solve(index: Int, sum: Int, str: String): Int {
        if (sum > 26 || sum <= 0) return 0
        if (index == str.length) return 1
        if (dp[index][sum] != -1) return dp[index][sum]
        dp[index][sum] = solve(index + 1, str[index] - '0', str) + solve(index + 1, sum * 10 + (str[index] - '0'), str)
        return dp[index][sum]
    }
    fun numDecodings(str: String): Int {
        return solve(1, str[0] - '0', str)
    }
}
fun main() {
    println(NumDecodings().numDecodings("226"))
}
