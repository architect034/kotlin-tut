package numsubarrayboundedmax

class NumSubArrayBoundedMax {
    private fun IntArray.maxOrNull(): Int? {
        var maxVal: Int? = null
        this.forEach {
            maxVal = maxVal?.let { maxVal -> kotlin.math.max(it, maxVal) }
        }
        return maxVal
    }
    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        var ans = 0
        var lastIndex = 0
        val subArrays: MutableList<MutableList<Int>> = mutableListOf()
        nums.forEachIndexed { index, num ->
            if (num > right) {
                val subArray = nums.sliceArray(IntRange(lastIndex, index - 1))
                val maxValue = subArray.maxOrNull()
                if (maxValue != null && maxValue < left) {
                    return@forEachIndexed
                }
                lastIndex = index + 1
                subArrays.add(subArray.toMutableList())
            }
        }
        val subArray = nums.sliceArray(IntRange(lastIndex, nums.lastIndex))
        subArrays.add(subArray.toMutableList())
        subArrays.forEach { array ->
            lastIndex = 0
            val n = array.size
            ans += (n * (n + 1)).shr(1)
            array.forEachIndexed { index, num ->
                if (num >= left) {
                    val sub = array.toIntArray().sliceArray(IntRange(lastIndex, index - 1))
                    val sz = sub.size
                    ans -= (sz * (sz + 1)).shr(1)
                    lastIndex = index + 1
                }
            }
            val sub = array.toIntArray().sliceArray(IntRange(lastIndex, array.lastIndex))
            val sz = sub.size
            ans -= (sz * (sz + 1)).shr(1)
        }
        return ans
    }
}

fun main() {
    NumSubArrayBoundedMax().numSubarrayBoundedMax(listOf(420).toIntArray(), 658, 761)
}
