package trianglenumber

class TriangleNumber {
    fun triangleNumber(arr: IntArray): Int {
        val sides = arr.sortedArray()
        var ans = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                val sumThreshold = sides[i] + sides[j]
                ans += numberOfSidesWeCnTake(sumThreshold, j + 1, sides)
            }
        }
        return ans
    }

    private fun numberOfSidesWeCnTake(threshold: Int, startIndex: Int, sides: IntArray): Int {
        var low = startIndex; var high = sides.size - 1; var ans = 0
        while (low <= high) {
            val mid = (low + high) / 2
            if (sides[mid] < threshold) {
                ans = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return if (ans == 0) 0 else ans - startIndex + 1
    }
}
