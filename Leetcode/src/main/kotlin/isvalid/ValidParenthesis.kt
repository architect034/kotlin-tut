package isvalid

import java.util.Stack

class ValidParenthesis {
    fun isValid(s: String?): Boolean? {
        var stack: Stack<Char> = Stack()
        if (s != null) {
            for (char in s) {
                if (char == '(' || char == '{' || char == '[') {
                    stack.push(char)
                    continue
                } else if (char == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                    return false
                } else if (char == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                    return false
                } else if (char == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                    return false
                }
                stack.pop()
            }
        }
        if (stack.empty()) {
            return true
        }
        return false
    }
}
