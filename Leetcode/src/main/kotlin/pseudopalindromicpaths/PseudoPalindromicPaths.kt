package pseudopalindromicpaths
import tree.TreeNode

class PseudoPalindromicPaths {
    private var hash = Array(10) { 0 }
    private fun checkIfPseudoPalindromicPath(): Boolean {
        var oneCount = 0
        for (count in hash) {
            if (count % 2 == 1) {
                oneCount++
            }
        }
        if (oneCount > 1) {
            return false
        }
        return true
    }

    private var answer = 0
    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }
        hash[node.`val`]++
        if (node.left != null) {
            dfs(node.left)
        }
        if (node.right != null) {
            dfs(node.right)
        }
        if (node.left == null && node.right == null) {
            if (checkIfPseudoPalindromicPath()) {
                answer++
            }
        }
        hash[node.`val`]--
    }

    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        dfs(root)
        return answer
    }
}

fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    val paths = PseudoPalindromicPaths().pseudoPalindromicPaths(root)
    println(paths)
}
