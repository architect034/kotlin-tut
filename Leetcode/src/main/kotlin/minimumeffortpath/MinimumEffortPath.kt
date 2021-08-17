package minimumeffortpath

import java.util.ArrayDeque
import java.util.Queue
import kotlin.math.abs
import kotlin.properties.Delegates

class MinimumEffortPath {
    lateinit var heights: Array<IntArray>
    var n by Delegates.notNull<Int>()
    var m by Delegates.notNull<Int>()
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        this.heights = heights
        var low = 0
        var high = 1000001
        var answer = high
        n = heights.size
        m = heights[0].size
        while (low <= high) {
            val mid = (low + high).shr(1)
            if (checkIfPossible(mid)) {
                answer = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return answer
    }

    private fun isValidCoordinate(x: Int, y: Int): Boolean {
        return ((x in 0 until n) && (y in 0 until m))
    }

    private fun checkIfPossible(difference: Int): Boolean {
        var queue: Queue<Pair<Int, Int>> = ArrayDeque()
        val visited: Array<Array<Boolean>> = Array(n) { Array(m) { false } }
        queue.add(Pair(0, 0))
        visited[0][0] = true
        while (queue.isNotEmpty()) {
            val x = queue.peek().first
            val y = queue.peek().second
            queue.remove()
            if (x == n - 1 && y == m - 1) {
                return true
            }
            if (isValidCoordinate(x, y - 1) && !visited[x][y - 1] && (abs(heights[x][y - 1] - heights[x][y]) <= difference)) {
                queue.add(Pair(x, y - 1))
                visited[x][y - 1] = true
            }
            if (isValidCoordinate(x - 1, y) && !visited[x - 1][y] && (abs(heights[x - 1][y] - heights[x][y]) <= difference)) {
                queue.add(Pair(x - 1, y))
                visited[x - 1][y] = true
            }
            if (isValidCoordinate(x, y + 1) && !visited[x][y + 1] && (abs(heights[x][y + 1] - heights[x][y]) <= difference)) {
                queue.add(Pair(x, y + 1))
                visited[x][y + 1] = true
            }
            if (isValidCoordinate(x + 1, y) && !visited[x + 1][y] && (abs(heights[x + 1][y] - heights[x][y]) <= difference)) {
                queue.add(Pair(x + 1, y))
                visited[x + 1][y] = true
            }
        }
        return false
    }
}
