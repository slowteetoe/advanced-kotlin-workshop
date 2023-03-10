package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main(): Unit = runBlocking {
    println("starting to count...")

    val job = launch {
        for (i in 0 .. 3) {
            launch{
                delay(1000L * i)
                println(i)
            }
        }
    }

    println("Done counting")
}