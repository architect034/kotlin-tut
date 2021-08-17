package rightsideview

import tree.TreeNode
import java.util.SortedMap

class RightSideView {
    private val map: SortedMap<Int, Int> = sortedMapOf()
    private fun dfs(node: TreeNode?, level: Int) {
        if (node == null) return
        map[level] = node.`val`
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
    }
    fun rightSideView(root: TreeNode?): List<Int> {
        dfs(root, 0)
        return map.values.toMutableList()
    }
}
