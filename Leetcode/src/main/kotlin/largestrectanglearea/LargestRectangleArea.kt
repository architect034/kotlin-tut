package largestrectanglearea
import java.util.Stack
import kotlin.math.max

class LargestRectangleArea {
    fun largestRectangleArea(heights: IntArray): Int {
        if (heights.isEmpty()) return 0
        val stack = Stack<Int>()
        stack.push(0)
        var index = 0
        var answer = 0
        while (++index < heights.size) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[index]) {
                val bar = stack.peek()
                stack.pop()
                answer = if (stack.isNotEmpty()) {
                    max(answer, (index - stack.peek() - 1) * heights[bar])
                } else {
                    max(answer, (index) * heights[bar])
                }
            }
            stack.push(index)
        }
        while (stack.isNotEmpty()) {
            val bar = stack.peek()
            stack.pop()
            answer = if (stack.isNotEmpty()) {
                max(answer, (index - stack.peek() - 1) * heights[bar])
            } else {
                max(answer, (index) * heights[bar])
            }
        }

        return answer
    }
}

fun main() {
    var arr = IntArray(6)
    arr[0] = 2
    arr[1] = 1
    arr[2] = 5
    arr[3] = 6
    arr[4] = 2
    arr[5] = 3
    println(LargestRectangleArea().largestRectangleArea(arr))
}
