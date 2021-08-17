import kotlin.properties.Delegates

class combinationsum4 {
    // dp[pos][remSum]
    private val dp =
        IntArray(1001) { -1 }

    var size = 0
    var arr: IntArray by Delegates.notNull()

    private fun solve(target: Int): Int {
        if (target == 0) {
            return 1
        }
        if (target < 0) {
            return 0
        }
        if (dp[target] != -1) return dp[target]
        var sum = 0
        for (i in 0 until size) {
            sum += solve(target - arr[i])
        }
        dp[target] = sum
        return dp[target]
    }
    fun combinationSum4(nums: IntArray, target: Int): Int {
        arr = nums
        size = nums.size
        return solve(target)
    }
}
