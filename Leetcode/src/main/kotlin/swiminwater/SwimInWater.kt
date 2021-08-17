package swiminwater

import java.lang.Integer.max
import java.util.PriorityQueue
import kotlin.collections.HashMap

class SwimInWater {
    private var explored: MutableSet<Int> = mutableSetOf()
    private lateinit var grid: Array<IntArray>
    fun swimInWater(grid: Array<IntArray>): Int {
        this.grid = grid
        explored = mutableSetOf()
        val valToPos: HashMap<Int, Pair<Int, Int>> = hashMapOf()
        val pq: PriorityQueue<Int> = PriorityQueue(compareBy { it })
        grid.forEachIndexed { i, row -> row.forEachIndexed { j, value -> valToPos[value] = Pair(i, j) } }
        pq.add(grid[0][0])
        var maxValInPath = 0
        val dxy = listOf(listOf(0, -1), listOf(-1, 0), listOf(0, 1), listOf(1, 0))
        explored.add(grid[0][0])
        while (pq.isNotEmpty()) {
            val smallestValue = pq.poll()
            val smallValuePos = valToPos[smallestValue]!!
            maxValInPath = max(maxValInPath, smallestValue)
            if (smallValuePos.first == grid.lastIndex && smallValuePos.second == grid[0].lastIndex) { break }
            dxy.forEach {
                giveValueAtPos(Pair(smallValuePos.first + it[0], smallValuePos.second + it[1]))?.let { value ->
                    explored.add(value)
                    pq.add(value)
                }
            }
        }
        return maxValInPath
    }
    private fun giveValueAtPos(pos: Pair<Int, Int>): Int? {
        val x = pos.first
        val y = pos.second
        if (x in 0..grid.lastIndex && y in 0..grid[0].lastIndex && !explored.contains(grid[x][y])) {
            return grid[x][y]
        }
        return null
    }
}
