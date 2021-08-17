package narypreorder

import node.Node

class NAryPreOrder {
    private val listOfNodesVal = mutableListOf<Int>()

    private fun preOrder(node: Node?) {
        if (node == null) return
        listOfNodesVal.add(node.`val`)
        for (childNode in node.children) {
            preOrder(childNode)
        }
    }

    fun preorder(root: Node?): List<Int> {
        preOrder(root)
        return listOfNodesVal
    }
}

fun solve(n: Int) {
    val arr = LongArray(51) {
        0
    }
    arr[1] = 1
    arr[2] = 1
    for (i in 3 until 51) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    if (n < 0) {
        println("Enter the valid number of days to know number of petals on flower on that day")
        return
    }
    var ans: Long = 0
    for (i in 1 until n + 1) {
        ans += arr[i]
    }
    println(ans)
}

fun main() {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
    }
}
