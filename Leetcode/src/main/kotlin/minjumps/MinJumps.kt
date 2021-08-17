package minjumps
import java.util.LinkedList

class MinJumps {
    fun minJumps(arr: IntArray): Int {
        var answer = 0
        val n = arr.size
        val graph = HashMap<Int, LinkedList<Int>>()
        for (index in arr.indices) {
            graph.computeIfAbsent(
                arr[index]
            ) { LinkedList<Int>() }.add(index)
        }
        val visited = MutableList(n) {
            return@MutableList false
        }
        var layer = LinkedList<Int>()
        layer.add(0)
        while (layer.isNotEmpty()) {
            val newLayer = LinkedList<Int>()
            for (value in layer) {
                if (value == n - 1) {
                    return answer
                }
                for (child in graph.getOrDefault(arr[value], LinkedList())) {
                    if (!visited[child]) {
                        visited[child] = true
                        newLayer.add(child)
                    }
                }
                graph[arr[value]]?.clear()
                if (value - 1 >= 0 && !visited[value - 1]) {
                    visited[value - 1] = true
                    newLayer.add(value - 1)
                }
                if (value + 1 < n && !visited[value + 1]) {
                    visited[value + 1] = true
                    newLayer.add(value + 1)
                }
            }
            answer++
            layer = newLayer
        }
        return -1
    }
}

fun main() {
    val arr = IntArray(100)
    arr[0] = 1
    MinJumps().minJumps(arr)
}
