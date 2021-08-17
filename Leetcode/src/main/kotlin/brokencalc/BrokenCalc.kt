package brokencalc

import java.util.Stack
import kotlin.math.max

class BrokenCalc {
    fun brokenCalc(X: Int, Y: Int): Int {
        var ans = 0
        var Y = Y
        while (Y > X) {
            ans++
            if (Y % 2 == 1) Y++ else Y /= 2
        }

        return ans + X - Y
    }
    fun doTask(str: String): Int {
        var ans = 0
        var cur = 0
        var temp = 0
        var close: Boolean = false
        val st: Stack<Char> = Stack()
        for (ch in str) {
            if (ch == '(') {
                st.push('(')
                close = true
            } else {
                st.pop()
                temp = max(temp * 2, 1)
                if (st.isEmpty() || close) {
                    cur += temp
                    temp = 0
                }
                close = false
            }
        }
        return cur
    }
}
