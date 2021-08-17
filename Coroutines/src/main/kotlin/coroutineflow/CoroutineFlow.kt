package coroutineflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class CoroutineFlow {
    fun someWork(): Flow<Int> {
        return flow {
            delay(100)
            emit(100)
        }
    }
}

fun main() {
    runBlocking {
        CoroutineFlow().someWork().collect {
            println(it)
        }
    }
}
