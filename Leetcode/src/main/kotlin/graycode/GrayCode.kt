package graycode

class GrayCode {
    fun grayCode(n: Int): List<Int> {
        val codes: MutableList<String> = mutableListOf("0", "1")
        for (i in 2..n) {
            val list1 = codes.map { "0$it" }
            val list2 = listOf(*codes.toTypedArray().reversedArray()).map { "1$it" }
            codes.clear()
            codes.apply {
                addAll(list1)
                addAll(list2)
            }
        }
        return codes.map { getIntFromBinary(it) }
    }
    private fun getIntFromBinary(code: String): Int {
        val code = code.reversed()
        var ans = 0
        var powerOfTwo = 1
        for (i in code.indices) {
            ans += code[i].toString().toInt() * powerOfTwo
            powerOfTwo *= 2
        }
        return ans
    }
}
