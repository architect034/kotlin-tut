package getmaximumgenerated

class GetMaximumGenerated {
    fun getMaximumGenerated(n: Int): Int {
        if (n < 1) return 0
        if (n == 1) return 1
        var ans = 0
        val generatedArray: Array<Int> = Array(n) { 0 }
        generatedArray[0] = 0
        generatedArray[1] = 1
        for (index in 2 until n) {
            if (index % 2 == 0) {
                generatedArray[index] = generatedArray[index / 2]
            } else {
                generatedArray[index] = generatedArray[index / 2] + generatedArray[index / 2 + 1]
            }
            ans = maxOf(ans, generatedArray[index])
        }
        return ans
    }
}
