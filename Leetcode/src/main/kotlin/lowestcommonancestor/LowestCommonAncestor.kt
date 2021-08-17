package lowestcommonancestor

import tree.TreeNode

class LowestCommonAncestor {
    fun lowestCommonAncestor(node: TreeNode?, a: TreeNode?, b: TreeNode?): TreeNode? {
        if (node == null) return null
        if (node == a || node == b) {
            return node
        }
        val fromLeft = lowestCommonAncestor(node.left, a, b)
        val fromRight = lowestCommonAncestor(node.right, a, b)
        return if (fromLeft != null && fromRight != null) {
            node
        } else fromLeft ?: fromRight
    }
}
