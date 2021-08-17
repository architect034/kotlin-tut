package isvalidbst
import tree.TreeNode

class IsValidBST {
    private fun checkBst(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true
        if ((root.`val` <= min && root.`val` != Int.MIN_VALUE) || (root.`val` >= max && root.`val` != Int.MAX_VALUE)) {
            return false
        }
        return checkBst(root.left, min, root.`val`.toLong()) && checkBst(root.right, root.`val`.toLong(), max)
    }
    fun isValidBST(root: TreeNode?): Boolean {
        return checkBst(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}
fun main() {
    val root = TreeNode(2147483647)
    println(IsValidBST().isValidBST(root))
}
