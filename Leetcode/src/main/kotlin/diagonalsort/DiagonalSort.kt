package diagonalsort

class DiagonalSort {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val totalRows = mat.size
        val totalCols = mat[0].size
        var row = totalRows - 1
        while (row >= 0) {
            var currRow = row
            var currCol = 0
            val list = mutableListOf<Int>()
            while (currRow < totalRows && currCol < totalCols) {
                list.add(mat[currRow++][currCol++])
            }
            list.sort()
            currRow = row
            currCol = 0
            var index = 0
            while (currRow < totalRows && currCol < totalCols) {
                mat[currRow++][currCol++] = list[index++]
            }
            row--
        }
        var col = 1
        while (col < totalCols) {
            var currRow = 0
            var currCol = col
            val list = mutableListOf<Int>()
            while (currCol < totalCols && currRow < totalRows) {
                list.add(mat[currRow++][currCol++])
            }
            list.sort()
            currRow = 0
            currCol = col
            var index = 0
            while (currCol < totalCols && currRow < totalRows) {
                mat[currRow++][currCol++] = list[index++]
            }
            col++
        }
        return mat
    }
}
