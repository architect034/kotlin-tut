package singlenumber

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val map: HashMap<Int, Int> = HashMap()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        map.forEach {
            if (it.value == 1) {
                return it.key
            }
        }
        return -1
    }
}
