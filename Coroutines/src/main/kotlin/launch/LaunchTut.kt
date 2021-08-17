package launch

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LaunchTut {
    fun launchTut() {
        runBlocking {
            launch {
                delay(5000L)
                println("World Again")
            }
            println("World")
        }
    }
}

fun main() {
    LaunchTut().launchTut()
}
