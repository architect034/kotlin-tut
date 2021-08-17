package pathsum

import tree.TreeNode
import java.util.LinkedList

class PathSum {
    private val pathsWithSum: MutableList<MutableList<Int>> = mutableListOf()
    private fun findPath(node: TreeNode?, remaining: Int, arrayOfNodes: LinkedList<Int>) {
        if (node == null) return
        arrayOfNodes.push(node.`val`)
        if (node.left == null && node.right == null && remaining == node.`val`) {
            val path = mutableListOf<Int>()
            arrayOfNodes.forEach {
                path.add(it)
            }
            path.reverse()
            pathsWithSum.add(path)
            arrayOfNodes.pop()
            return
        }
        findPath(node.left, remaining - node.`val`, arrayOfNodes)
        findPath(node.right, remaining - node.`val`, arrayOfNodes)
        arrayOfNodes.pop()
    }
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val arrayOfNodes: LinkedList<Int> = LinkedList()
        findPath(root, sum, arrayOfNodes)
        return pathsWithSum
    }

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        val arrayOfNodes: LinkedList<Int> = LinkedList()
        findPath(root, sum, arrayOfNodes)
        return pathsWithSum.size > 0
    }
}

fun main() {
    val root = TreeNode(-2)
    root.right = TreeNode(-3)
    val paths = PathSum().pathSum(root, -5)
    println(paths)
}
