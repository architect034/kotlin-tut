package prunetree

import tree.TreeNode

class PruneTree {
    private val sizeOfSubTree: HashMap<TreeNode, Int> = HashMap()
    private fun calculateSubTree(node: TreeNode?, parent: TreeNode? = null): Int {
        if (node == null) return 0
        var leftSubTreeSize = 0
        node.left?.let {
            leftSubTreeSize += calculateSubTree(it)
        }
        var rightSubTreeHeight = 0
        node.right?.let {
            rightSubTreeHeight += calculateSubTree(it)
        }
        sizeOfSubTree[node] = leftSubTreeSize + rightSubTreeHeight + node.`val`
        return sizeOfSubTree[node]!!
    }
    private fun pruneTreeUtil(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (sizeOfSubTree[root] == 0) return null
        root.left?.let {
            if (sizeOfSubTree[it] == 0) {
                root.left = null
            } else {
                pruneTreeUtil(root.left)
            }
        }
        root.right?.let {
            if (sizeOfSubTree[it] == 0) {
                root.right = null
            } else {
                pruneTreeUtil(root.right)
            }
        }
        return root
    }
    fun pruneTree(root: TreeNode?): TreeNode? {
        calculateSubTree(root)
        return pruneTreeUtil(root)
    }
}
