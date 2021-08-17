package minrefuelstops

import java.util.PriorityQueue

class MinRefuelStops {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var ans = 0
        var reachablePos = startFuel
        val pq = PriorityQueue<Int>(compareByDescending { it })
        stations.forEach { station ->
            val position = station[0]
            val fuel = station[1]
            when {
                reachablePos == target -> return ans
                reachablePos >= position -> {
                    pq.add(fuel)
                }
                else -> {
                    while (pq.size > 0 && reachablePos < position) {
                        reachablePos += pq.poll()
                        ans++
                    }
                    if (reachablePos < position) return -1
                    pq.add(fuel)
                }
            }
        }
        while (pq.size > 0 && reachablePos < target) {
            reachablePos += pq.poll()
            ans++
        }
        if (reachablePos < target) return -1
        return ans
    }
}
