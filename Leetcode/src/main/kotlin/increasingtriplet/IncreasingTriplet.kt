package increasingtriplet
import kotlin.math.max
import kotlin.math.min

class IncreasingTriplet {
    fun increasingTriplet(nums: IntArray): Boolean {
        val prefixSmallest = mutableListOf<Int>()
        val suffixGreatest = mutableListOf<Int>()
        prefixSmallest.add(nums[0])
        suffixGreatest.add(nums.last())
        var small = nums[0]
        for (i in 1 until nums.size) {
            small = min(small, nums[i])
            prefixSmallest.add(small)
        }
        var great = nums.last()
        for (i in nums.size - 1 downTo 0) {
            great = max(great, nums[i])
            suffixGreatest.add(great)
        }
        suffixGreatest.reverse()
        for (i in 1 until nums.size - 1) {
            if (prefixSmallest[i - 1] < nums[i] && nums[i] < suffixGreatest[i + 1]) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val arr = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as IntArray
    IncreasingTriplet().increasingTriplet(nums = arr)
}
