package kinversepair

import java.lang.Integer.min

class KInversePair {
    fun kInversePairs(n: Int, k: Int): Int {
        val dp: Array<IntArray> = Array(n + 1) { IntArray(k + 1) { 0 } }
        for (i in 0..n) {
            for (j in 0..k) {
                if (j == 0) {
                    dp[i][j] = 1
                    continue
                }
                for (p in 0..min(j, i - 1)) {
                    dp[i][j] += dp[i - 1][j - p]
                    dp[i][j] %= 1000000007
                }
            }
        }
        return dp[n][k]
    }
}
