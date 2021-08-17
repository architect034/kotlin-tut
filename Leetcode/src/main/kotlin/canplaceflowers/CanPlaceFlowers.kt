package canplaceflowers
class CanPlaceFlowers {
    fun canPlaceFlowers(flowerBed: MutableList<Int>, n: Int): Boolean {
        var count = 0
        val arr = mutableListOf<Int>()
        arr.add(0)
        for (i in 0 until flowerBed.size) {
            arr.add(flowerBed[i])
        }
        arr.add(0)
        for (i in 1 until flowerBed.size + 1) {
            if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                arr[i] = 1
                count++
            }
        }
        if (count >= n) {
            return true
        }
        return false
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>
    println(CanPlaceFlowers().canPlaceFlowers(arr, n))
}
