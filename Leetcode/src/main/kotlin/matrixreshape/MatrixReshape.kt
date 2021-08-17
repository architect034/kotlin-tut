package matrixreshape

class MatrixReshape {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val row = mat.size
        val col = mat[0].size
        if (row * col != r * c) return mat
        val flattenedArray = IntArray(row * col) { 0 }
        for (i in 0 until row) {
            for (j in 0 until col) {
                flattenedArray[i * col + j] = mat[i][j]
            }
        }
        val new2DArray = Array<IntArray>(r) { IntArray(c) { 0 } }
        for (i in 0 until r) {
            for (j in 0 until c) {
                new2DArray[i][j] = flattenedArray[i * c + j]
            }
        }
        return new2DArray
    }
}
