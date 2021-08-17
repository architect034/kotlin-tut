package makesquare

class MakeSquare {
    fun makesquare(matchsticks: IntArray): Boolean {
        var sidesSum = matchsticks.reduce { curSum, num -> curSum + num }
        if ((sidesSum / 4) * 4 != sidesSum) {
            return false
        }
        sidesSum /= 4
        val n = matchsticks.size
        val dp: HashMap<String, Boolean> = HashMap()
        fun leftShift(n: Int, pos: Int): Int {
            return n.shl(pos)
        }
        fun solve(mask: Int, sidesDone: Int): Boolean {
            var sidesDone = sidesDone
            var total = 0
            val key = "$mask|$sidesDone"
            for (i in (n - 1) downTo 0) {
                if ((mask and (1 shl i)) == 0) {
                    total += matchsticks[n - 1 - i]
                }
            }
            if (total > 0 && (total % sidesSum) == 0) {
                sidesDone++
            }
            if (sidesDone == 3) return true
            if (dp.containsKey(key)) return dp[key]!!
            val rem = ((total / sidesSum) + 1) * sidesSum - total
            var ans = false
            for (i in n - 1 downTo 0) {
                if (matchsticks[n - 1 - i] <= rem && (mask and (1 shl i)) > 0) {
                    if (solve(mask xor (1 shl i), sidesDone)) {
                        ans = true
                        break
                    }
                }
            }
            dp[key] = ans
            return dp[key]!!
        }
        return solve((1 shl n) - 1, 0)
    }
}

fun main() {
    MakeSquare().makesquare(IntArray(10) { i -> i + 1 })
}
