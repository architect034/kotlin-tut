package reachnumber
import kotlin.math.abs

class ReachNumber {
    fun reachNumber(target: Int): Int {
        var trgt = target
        var cur = 0
        var step = 0
        trgt = abs(trgt)
        while (cur < trgt) {
            cur += (++step)
        }
        println(cur - trgt)
        println(step)
        return if (cur == trgt || abs(cur - trgt) % 2 == 0) {
            step
        } else {
            if (step % 2 == 0) {
                step + 1
            } else {
                step + 2
            }
        }
    }
}
fun main() {
    println(ReachNumber().reachNumber(33))
}
