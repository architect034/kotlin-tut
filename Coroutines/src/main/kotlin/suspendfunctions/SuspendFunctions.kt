package suspendfunctions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SuspendFunctions {
    fun doWork() {
        runBlocking {
            doWorkSuspendOne()
            println("Call Me")
        }
    }
    private suspend fun doWorkSuspendOne() {
        coroutineScope {
            delay(2000L)
            launch {
                println("Inside suspend function")
            }
            launch {
                doWorkSuspendTwo()
            }
            launch {
                println("Inside suspend function 2")
            }
        }
    }

    private suspend fun doWorkSuspendTwo() {
        coroutineScope {
            launch {
                delay(5000L)
                println("Final")
            }
        }
    }
}

fun main() {
    SuspendFunctions().doWork()
}
