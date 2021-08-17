package zigzag

class ConvertZigZag {
    fun convert(str: String, numOfRows: Int): String {
        val matrix: Array<Array<Char>> = Array(numOfRows) { Array(str.length) { '#' } }
        var index = 0
        var col = 0
        var row = 0
        while (index < str.length) {
            while (index < str.length && row < numOfRows) {
                matrix[row++][col] = str[index++]
            }
            if (index < str.length) {
                row = numOfRows - 2
                col++
                while (row >= 1 && index < str.length) {
                    matrix[row--][col++] = str[index++]
                }
            }
            row = 0
        }
        index = 0
        val charArray = CharArray(str.length)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] != '#') {
                    charArray[index++] = matrix[i][j]
                }
            }
        }
        return String(charArray)
    }
}
