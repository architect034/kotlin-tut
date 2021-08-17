package generate

class Generate {
    fun generate(numRows: Int): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        for (i in 0 until numRows) {
            var value = 1
            val row: MutableList<Int> = mutableListOf()
            row.add(value)
            for (j in 1..i) {
                value = (value * (i - (j - 1))) / j
                row.add(value)
            }
            ans.add(row)
        }
        return ans
    }
}
