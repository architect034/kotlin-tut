package finddiagonalorder
class FindDiagonalOrder {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) return IntArray(0)
        val rows = matrix.size
        val cols = matrix[0].size
        var index = 0
        val listOfDiagonals = mutableListOf<MutableList<Int>>()
        var reversed = true
        for (i in 0 until cols) {
            var row = 0
            var col = i
            val diagonal = mutableListOf<Int>()
            while (col >= 0 && row < rows) {
                diagonal.add(matrix[row][col])
                row++
                col--
            }
            reversed = if (i % 2 == 0) {
                diagonal.reverse()
                true
            } else false
            listOfDiagonals.add(diagonal)
        }
        for (i in 1 until rows) {
            var row = i
            var col = cols - 1
            val diagonal = mutableListOf<Int>()
            while (row < rows && col >= 0 && col < cols) {
                diagonal.add(matrix[row][col])
                row++
                col--
            }
            reversed = if (!reversed) {
                diagonal.reverse()
                true
            } else {
                false
            }
            listOfDiagonals.add(diagonal)
        }
        val ans = IntArray(rows * cols)
        for (i in 0 until listOfDiagonals.size) {
            for (ele in listOfDiagonals[i]) {
                ans[index++] = ele
            }
        }
        return ans
    }
}

fun main() {
}
