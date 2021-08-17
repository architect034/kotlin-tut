package asyncawait

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class AsyncAwait {
    private suspend fun workOne(): Int {
        delay(1000L)
        return 10
    }
    private suspend fun workTwo(): Int {
        delay(1500L)
        return 15
    }
    fun doWork() {
        runBlocking {
            val resultOne = async { workOne() }
            val resultTwo = async { workTwo() }
            println(resultOne)
            println(resultOne.await() + resultTwo.await())
            println(resultOne)
        }
    }
}

fun main() {
    AsyncAwait().doWork()
}
