package threesumclosest

import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(arr: IntArray, target: Int): Int {
        var answer = Int.MAX_VALUE
        arr.sort()
        var diff = Int.MAX_VALUE
        for (index in 0..arr.size - 3) {
            val a = arr[index]
            var left = index + 1
            var right = arr.lastIndex
            val needed = target - a
            while (left < right) {
                if (abs(target - (a + arr[left] + arr[right])) < diff) {
                    diff = abs(target - (a + arr[left] + arr[right]))
                    answer = (a + arr[left] + arr[right])
                }
                when {
                    (arr[left] + arr[right]) < needed -> {
                        left++
                    }
                    (arr[left] + arr[right]) > needed -> {
                        right--
                    }
                    else -> {
                        return target
                    }
                }
            }
        }
        return answer
    }
}
