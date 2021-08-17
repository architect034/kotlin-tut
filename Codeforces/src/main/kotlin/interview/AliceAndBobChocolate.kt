package interview

import kotlin.math.min

class AliceAndBobChocolate {
    fun buyChocolate(chocolates: List<Int>): Int {
        var answer = 0
        var sum = 0
        val hashMap: HashMap<Int, Int> = HashMap()
        for (chocolate in chocolates) {
            sum += chocolate
            hashMap[chocolate] = hashMap.getOrDefault(chocolate, 0) + 1
        }
        answer = sum
        hashMap.forEach {
            answer = min(answer, sum - it.key * it.value)
        }
        return answer
    }
}
