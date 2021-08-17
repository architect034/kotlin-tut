package getorder

import java.util.PriorityQueue

data class Process(
    var index: Int,
    var enqueueTime: Int,
    var processingTime: Int
)

class GetOrder {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val priorityQueue: PriorityQueue<Process> = PriorityQueue { process1, process2 ->
            when {
                process1.processingTime < process2.processingTime -> { -1 }
                process1.processingTime > process2.processingTime -> { 1 }
                else -> {
                    if (process1.index < process2.index) -1
                    else 1
                }
            }
        }
        val listOfProcess: List<Process> = tasks.mapIndexed { index, process ->
            Process(index = index, enqueueTime = process[0], processingTime = process[1])
        }.sortedWith(
            Comparator { process1, process2 ->
                when {
                    process1.enqueueTime < process2.enqueueTime -> -1
                    process1.enqueueTime > process2.enqueueTime -> 1
                    else -> 0
                }
            }
        )
        var currentTime = 1
        var currentPos = 0
        val ans: MutableList<Int> = mutableListOf()
        while (currentPos < listOfProcess.size) {
            while (currentPos < listOfProcess.size && listOfProcess[currentPos].enqueueTime <= currentTime) {
                priorityQueue.add(listOfProcess[currentPos])
                currentPos++
            }
            if (priorityQueue.isEmpty() && currentPos < listOfProcess.size) {
                val tempPos = currentPos
                while (currentPos < listOfProcess.size && listOfProcess[tempPos].enqueueTime == listOfProcess[currentPos].enqueueTime) {
                    priorityQueue.add(listOfProcess[currentPos])
                    currentTime = listOfProcess[currentPos].enqueueTime
                    currentPos++
                }
            }
            val processToComplete = priorityQueue.poll()
            currentTime += processToComplete.processingTime
            ans.add(processToComplete.index)
        }
        while (priorityQueue.isNotEmpty()) {
            val processToComplete = priorityQueue.poll()
            currentTime += processToComplete.processingTime
            ans.add(processToComplete.index)
        }
        return ans.toIntArray()
    }
}

fun main() {
    val ans = GetOrder().getOrder(
        tasks =
        listOf(
            listOf(7, 10).toIntArray(),
            listOf(7, 12).toIntArray(),
            listOf(7, 5).toIntArray(),
            listOf(7, 4).toIntArray(),
            listOf(7, 2).toIntArray()
        ).toTypedArray()
    )
    ans.forEach { print("$it, ") }
}
