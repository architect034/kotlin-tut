package simplifypath

import java.util.Stack

class SimplifyPath {
    fun simplifyPath(path: String = "/a/../../b/../c//.//"): String {
        val ops = path.split("/").filter {
            it.isNotEmpty()
        }
        print(ops)
        var stack: Stack<String> = Stack()
        for (op in ops) {
            if (op == ".") continue
            else if (op == "..") {
                if (stack.isNotEmpty())
                    stack.pop()
            } else stack.push(op)
        }
        return stack.joinToString("/", "/", "")
    }
}

fun main() {
    val ans = SimplifyPath().simplifyPath()
    print(ans)
}
