package deepestleavessum

import tree.TreeNode
import kotlin.math.max
import kotlin.properties.Delegates

class DeepestLeavesSum {

    private var maxLevel by Delegates.notNull<Int>()

    private fun calcHeight(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(calcHeight(root.left), calcHeight(root.right))
    }

    private fun calculate(root: TreeNode?, level: Int): Int {
        if (root == null) return 0
        if (level == maxLevel) return root.`val`
        return calculate(root.left, level + 1) + calculate(root.right, level + 1)
    }

    fun deepestLeavesSum(root: TreeNode): Int {
        maxLevel = calcHeight(root)
        return calculate(root, 1)
    }
}
