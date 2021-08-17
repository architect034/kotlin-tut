package removeduplicates

import java.util.Stack

class RemoveDuplicates {
    fun removeDuplicates(str: String): String {
        val ans: Stack<Char> = Stack()
        str.forEach {
            if (ans.isEmpty() || ans.peek() != it) {
                ans.push(it)
                return@forEach
            }
            while (ans.isNotEmpty() && ans.peek() == it) {
                ans.pop()
            }
        }
        return ans.joinToString("")
    }
}
