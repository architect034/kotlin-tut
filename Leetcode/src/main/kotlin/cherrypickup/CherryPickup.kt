package cherrypickup
import kotlin.math.max

class CherryPickup {
    private val dp = Array(100) { Array(100) { Array<Int>(100) { _ -> -1 } } }
    fun cherryPickup(grid: MutableList<MutableList<Int>>): Int {
        val rows = grid.size
        val cols = grid[0].size
        return solve(0, 0, cols - 1, rows, cols, grid)
    }
    private fun solve(row: Int, colA: Int, colB: Int, totalRows: Int, totalCols: Int, grid: MutableList<MutableList<Int>>): Int {
        if (row >= totalRows || colA >= totalCols || colA < 0 || colB >= totalCols || colB < 0)
            return 0
        if (dp[row][colA][colB] != -1) return dp[row][colA][colB]
        var res = 0
        res += grid[row][colA]
        if (colA != colB) {
            res += grid[row][colB]
        }

        if (row <= totalRows) {
            var max = 0
            for (j in colA - 1..colA + 1) {
                for (k in colB - 1..colB + 1) {
                    max = max(max, solve(row + 1, j, k, totalRows, totalCols, grid))
                }
            }
            res += max
        }
        dp[row][colA][colB] = res
        return res
    }
}

fun main() {
    val x = mutableListOf<MutableList<Int>>(mutableListOf(1, 2, 3), mutableListOf(2, 3, 4))
    CherryPickup().cherryPickup(x)
}
