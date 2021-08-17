package minremovetomakevalid

import java.lang.StringBuilder
import java.util.Stack

class MinRemoveToMakeValid {
    fun minRemoveToMakeValid(s: String): String {
        val removeList: MutableList<Int> = mutableListOf()
        var stack: Stack<Int> = Stack()
        for (index in s.indices) {
            if (s[index] == '(') stack.push(index)
            else if (s[index] == ')') {
                if (stack.isNotEmpty()) {
                    stack.pop()
                } else {
                    removeList.add(index)
                }
            }
        }
        stack.forEach {
            removeList.add(it)
        }
        removeList.sort()
        println(removeList)
        val ans: StringBuilder = StringBuilder()
        var removeIndex = 0
        for (i in s.indices) {
            if (i == removeIndex) continue
            ans.append(s[i])
        }
        return ans.toString()
    }
}
