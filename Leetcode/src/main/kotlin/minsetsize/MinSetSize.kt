package minsetsize
import kotlin.collections.HashMap

class MinSetSize {
    private data class CountAndNumber(
        val count: Int,
        val number: Int
    )
    fun minSetSize(arr: IntArray): Int {
        var ans = 0
        var hashMap: HashMap<Int, Int> = hashMapOf()
        for (num in arr) {
            hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        }
        val countWithNumber: MutableList<CountAndNumber> = mutableListOf()
        for (key in hashMap.keys) {
            countWithNumber.add(CountAndNumber(count = hashMap[key]!!, number = key))
        }
        countWithNumber.sortWith(
            kotlin.Comparator { object1, object2 ->
                object2.count - object1.count
            }
        )
        var half = (arr.size + 1) / 2
        for (obj in countWithNumber) {
            if (half > 0) {
                half -= (obj.count)
                ans++
            } else {
                break
            }
        }
        return ans
    }
}
