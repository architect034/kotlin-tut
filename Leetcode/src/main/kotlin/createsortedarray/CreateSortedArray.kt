package createsortedarray

import java.util.TreeSet
import kotlin.math.min

class CreateSortedArray {
    fun createSortedArray(instructions: IntArray): Int {
        var answer = 0
        val count: Array<Int> = Array(100001) { 0 }
        val set: TreeSet<Int> = sortedSetOf()
        for (index in instructions.indices) {
            val num = instructions[index]
            val lowerKaSize = set.subSet(Int.MIN_VALUE, num).size
            count[num]++
            set.add(num)
            answer += min(lowerKaSize, (index + 1 - (lowerKaSize + count[num])))
        }
        return answer
    }
}

fun main() {
    val arr: IntArray = IntArray(4)
    arr[0] = 1
    arr[1] = 1
    arr[2] = 2
    arr[3] = 1
    CreateSortedArray().createSortedArray(arr)
}
