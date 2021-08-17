package generatematrix

class GenerateMatrix {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix: Array<IntArray> = Array(n) { IntArray(n) }
        var upperRow = 0
        var lowerRow = n - 1
        var leftCol = 0
        var rightCol = n - 1
        var value = 0
        while (upperRow <= lowerRow && leftCol <= rightCol) {
            for (i in leftCol..rightCol) {
                matrix[upperRow][i] = ++value
            }
            for (i in upperRow + 1..lowerRow) {
                matrix[i][rightCol] = ++value
            }
            for (i in rightCol - 1 downTo leftCol) {
                matrix[lowerRow][i] = ++value
            }
            for (i in lowerRow - 1 downTo upperRow + 1) {
                matrix[i][leftCol] = ++value
            }
            leftCol++
            rightCol--
            upperRow++
            lowerRow--
        }
        return matrix
    }
}
