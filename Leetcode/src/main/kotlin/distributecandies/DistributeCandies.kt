package distributecandies

import kotlin.math.min

class DistributeCandies {
    fun distributeCandies(candyType: IntArray): Int {
        val setOfCandyTypes: MutableSet<Int> = mutableSetOf()
        for (type in candyType) setOfCandyTypes.add(type)
        val canEat = candyType.size.shr(1)
        return min(canEat, setOfCandyTypes.size)
    }
}
