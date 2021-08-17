package lengthoflis

import kotlin.math.max

class LengthOfLIS {
    fun lengthOfLIS(arr: IntArray): Int {
        val n = arr.size
        var dp = IntArray(n) { 1 }
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (arr[j] > arr[i]) {
                    dp[j] = max(dp[j], dp[i] + 1)
                }
            }
        }
        return dp.reduce { runningMax, curr -> max(runningMax, curr) }
    }
}
