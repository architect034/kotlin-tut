package validatestacksequences

import java.util.Stack

class ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack: Stack<Int> = Stack()
        var popIndex = 0; var n = pushed.size
        for (num in pushed) {
            stack.push(num)
            while (stack.isNotEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop()
                popIndex++
            }
        }
        return stack.isEmpty()
    }
}
