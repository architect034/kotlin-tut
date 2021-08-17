package largestisland

import kotlin.math.max
import kotlin.properties.Delegates

class LargestIsland {

    private lateinit var root: IntArray
    private lateinit var size: IntArray
    private var row by Delegates.notNull<Int>()
    private var col by Delegates.notNull<Int>()

    private fun findRoot(x: Int): Int {
        var mutableX = x
        while (root[mutableX] != mutableX) {
            mutableX = root[root[mutableX]]
        }
        return mutableX
    }

    private fun union(x: Int, y: Int) {
        val rootX = findRoot(x)
        val rootY = findRoot(y)
        when {
            rootX == rootY -> return
            rootX >= rootY -> {
                size[rootX] += size[rootY]
                size[rootY] = 0
                root[rootY] = rootX
            }
            else -> {
                size[rootY] += size[rootX]
                size[rootX] = 0
                root[rootX] = rootY
            }
        }
    }

    private fun getIndex(i: Int, j: Int): Int = i * col + j

    private fun isValidCell(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return x in 0 until row && y in 0 until col && grid[x][y] == 1
    }

    fun largestIsland(grid: Array<IntArray>): Int {
        row = grid.size
        col = grid[0].size
        val len = row * col
        root = IntArray(len) { i -> i }
        size = IntArray(len) { 1 }
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == 1 && j + 1 < col && grid[i][j + 1] == 1) {
                    union(getIndex(i, j), getIndex(i, j + 1))
                }
                if (grid[i][j] == 1 && i + 1 < row && grid[i + 1][j] == 1) {
                    union(getIndex(i, j), getIndex(i + 1, j))
                }
            }
        }
        var ans = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == 1) {
                    ans = max(ans, size[root[getIndex(i, j)]])
                    continue
                }
                val indices: MutableList<Int> = mutableListOf()
                for (dxy in listOf(Pair(0, 1), Pair(1, 0), Pair(-1, 0), Pair(0, -1))) {
                    if (isValidCell(i + dxy.first, j + dxy.second, grid)) {
                        indices.add(getIndex(i + dxy.first, j + dxy.second))
                    }
                }
                val uniqueRoots: MutableSet<Int> = mutableSetOf()
                for (index in indices) {
                    uniqueRoots.add(findRoot(index))
                }
                var count = 1
                for (uniqueRoot in uniqueRoots) {
                    count += size[uniqueRoot]
                }
                ans = max(ans, count)
            }
        }
        return max(1, ans)
    }
}
