package nextgreaterelement
import java.util.Collections.swap

class NextGreaterElement {
    fun nextGreaterElement(n: Int): Int {
        println(Int.MAX_VALUE)
        if (n >= Int.MAX_VALUE) {
            return -1
        }
        val listOfIntegers: MutableList<Int> = mutableListOf()
        var num = n
        while (num > 0) {
            listOfIntegers.add(num % 10)
            num /= 10
        }
        listOfIntegers.reverse()
        for (index in listOfIntegers.size - 1 downTo 0) {
            val value = listOfIntegers[index]
            var smallestValue = -1
            for (i in index + 1 until listOfIntegers.size) {
                if (listOfIntegers[i] > value) {
                    if (smallestValue == -1) {
                        smallestValue = i
                    }
                    if (listOfIntegers[i] < listOfIntegers[smallestValue]) {
                        smallestValue = i
                    }
                }
            }
            if (smallestValue != -1) {
                swap(listOfIntegers, index, smallestValue)
                val arr: Array<Int> = listOfIntegers.toTypedArray()
                arr.sort(index + 1, arr.size)
                var ans = 0L
                for (i in arr) {
                    ans = ans * 10 + i
                }
                if (ans > Int.MAX_VALUE) {
                    return -1
                }
                return ans.toInt()
            }
        }
        return -1
    }
}

fun main() {
    println(NextGreaterElement().nextGreaterElement(230241))
}
