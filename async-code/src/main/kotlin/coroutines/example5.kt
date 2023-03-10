package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private suspend fun longRunningTask1() : Int {
    delay(2000)
    return 3
}

private suspend fun longRunningTask2() : Int {
    delay(3000)
    return 2
}

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val one = async { longRunningTask1() }
        val two = async { longRunningTask2() }
        println("the answer is ${one.await() + two.await()}")
    }
    println("Took $time millis")
}