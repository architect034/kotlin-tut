package findclosestelements

import kotlin.math.abs

data class ElementInfo(
    val absoluteDifference: Int,
    val actualValue: Int
)

class FindClosestElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val ans: MutableList<ElementInfo> = arr.map {
            ElementInfo(absoluteDifference = abs(x - it), actualValue = it)
        }.toMutableList()
        ans.sortWith(
            Comparator { element1, element2 ->
                if (element1.absoluteDifference == element2.absoluteDifference) {
                    element1.actualValue - element2.actualValue
                } else {
                    element1.absoluteDifference - element2.absoluteDifference
                }
            }
        )
        return ans.filterIndexed { index, _ -> index < k }.map { it.actualValue }.sorted()
    }
}
