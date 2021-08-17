package sumnumbers
import tree.TreeNode

class SumNumbers {
    private var answer = 0
    private fun calculateSum(node: TreeNode?, current: Int) {
        var curr = current
        if (node == null) {
            return
        }
        if (node.left == null && node.right == null) {
            answer += current * 10 + node.`val`
            return
        }
        curr = curr * 10 + node.`val`
        calculateSum(node.left, curr)
        calculateSum(node.right, curr)
    }

    fun sumNumbers(root: TreeNode?): Int {
        var current = 0
        calculateSum(root, current)
        return answer
    }
}

fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    val ans = SumNumbers().sumNumbers(root)
    println(ans)
}
