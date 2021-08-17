package treetraversal

import tree.TreeNode

class PreorderTraversal {
    private val preorderNode = mutableListOf<Int>()
    private fun traverse(node: TreeNode?) {
        if (node == null) return
        preorderNode.add(node.`val`)
        traverse(node.left)
        traverse(node.right)
    }
    fun preorderTraversal(root: TreeNode?): List<Int> {
        traverse(root)
        return preorderNode
    }
}
