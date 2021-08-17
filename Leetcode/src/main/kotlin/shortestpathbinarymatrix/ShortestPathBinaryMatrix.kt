package shortestpathbinarymatrix

import java.util.ArrayDeque
import java.util.Queue
import kotlin.math.min
import kotlin.properties.Delegates

data class PointDetails(
    val x: Int,
    val y: Int,
    val distance: Int
)

class ShortestPathBinaryMatrix {
    private val diff: List<Int> = listOf(-1, 0, 1)
    private var rows by Delegates.notNull<Int>()
    private var cols by Delegates.notNull<Int>()
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var distance = Int.MAX_VALUE
        rows = grid.size; cols = grid[0].size
        if (grid[0][0] == 1) return -1
        val visited: Array<Array<Boolean>> = Array(rows) { Array(cols) { false } }
        val queue: Queue<PointDetails> = ArrayDeque()
        queue.add(PointDetails(0, 0, 1))
        visited[0][0] = true
        while (queue.isNotEmpty()) {
            val currentPointDetails = queue.poll()
            val x = currentPointDetails.x; val y = currentPointDetails.y; val dist = currentPointDetails.distance
            if (x == rows - 1 && y == cols - 1) {
                distance = min(dist, distance)
            }
            for (dx in diff) {
                for (dy in diff) {
                    if (Pair(x + dx, y + dy).isValid() && !visited[x + dx][y + dy] && grid[x + dx][y + dy] == 0) {
                        queue.add(PointDetails(x + dx, y + dy, dist + 1))
                        visited[x + dx][y + dy] = true
                    }
                }
            }
        }
        return if (distance == Int.MAX_VALUE) -1 else distance
    }

    private fun Pair<Int, Int>.isValid(): Boolean {
        return ((this.first in 0 until rows) && (this.second in 0 until cols))
    }
}
