package longestincreasingpath

import kotlin.math.max
import kotlin.properties.Delegates

class LongestIncreasingPath {
    private var rows by Delegates.notNull<Int>()
    private var cols by Delegates.notNull<Int>()
    private lateinit var mat: Array<IntArray>
    private var ans: Int = 0

    private val dp: Array<IntArray> = Array(201) {
        IntArray(201) { -1 }
    }

    private val dxy = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    private fun solve(i: Int, j: Int, len: Int): Int {
        if (dp[i][j] != -1) return dp[i][j]
        var cur = 1
        for (change in dxy) {
            val x = i + change.first
            val y = j + change.second
            if (checkIfOutOfBounds(x, y) && mat[x][y] > mat[i][j]) {
                cur = max(cur, 1 + solve(x, y, len + 1))
            }
        }
        dp[i][j] = cur

        return cur
    }

    private fun checkIfOutOfBounds(i: Int, j: Int): Boolean {
        return i in 0 until rows && j in 0 until cols
    }

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        mat = matrix
        rows = mat.size
        cols = mat[0].size
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                ans = max(ans, solve(i, j, 1))
            }
        }
        return ans
    }
}
