package foursum
class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val answerList: MutableList<MutableList<Int>> = mutableListOf()
        val setOfQuads: MutableSet<MutableList<Int>> = mutableSetOf()
        nums.sort()
        for (i in 0 until nums.size - 3) {
            for (j in i + 1 until nums.size - 2) {
                val a = nums[i]
                val b = nums[j]
                val sum = a + b
                var st = j + 1
                var end = nums.size - 1
                val needed = target - sum
                while (st < end) {
                    when {
                        nums[st] + nums[end] > needed -> {
                            end--
                        }
                        nums[st] + nums[end] < needed -> {
                            st++
                        }
                        else -> {
                            val quads = mutableListOf<Int>()
                            quads.add(a)
                            quads.add(b)
                            quads.add(nums[st])
                            quads.add(nums[end])
                            quads.sort()
                            setOfQuads.add(quads)
                            st++
                            end--
                            while (st < end && nums[st] == nums[st - 1]) {
                                st++
                            }
                            while (end > st && nums[end] == nums[end + 1]) {
                                end--
                            }
                        }
                    }
                }
            }
        }
        setOfQuads.forEach {
            answerList.add(it)
        }
        return answerList
    }
}

fun main() {
}
