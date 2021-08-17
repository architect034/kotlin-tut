package furthestbuilding

class FurthestBuilding {
    private lateinit var buildingHeights: IntArray
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        buildingHeights = heights
        var low = 1; var high = heights.size - 1
        var maximumDistanceReachable = 0
        while (low <= high) {
            val mid = (low + high).shr(1)
            if (isReachable(mid, bricks, ladders)) {
                maximumDistanceReachable = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return maximumDistanceReachable
    }

    private fun isReachable(index: Int, bricks: Int, ladders: Int): Boolean {
        var bricks = bricks; var ladders = ladders
        val difference: MutableList<Int> = mutableListOf()
        for (i in 0 until index) {
            if (buildingHeights[i + 1] > buildingHeights[i]) {
                difference.add(buildingHeights[i + 1] - buildingHeights[i])
            }
        }
        difference.sortDescending()
        for (diff in difference) {
            if (ladders > 0) ladders--
            else {
                if (bricks <= 0) {
                    return false
                } else {
                    bricks -= diff
                }
            }
        }
        return true
    }
}
