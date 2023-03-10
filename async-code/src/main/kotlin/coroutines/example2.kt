package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private suspend fun helloWorld() {
    println("helloWorld() running in ${Thread.currentThread().name}")
    println("Hello World!")
}

private suspend fun helloWorld2() {
    println("helloWorld2() running in ${Thread.currentThread().name}")
    throw IllegalArgumentException("nope")
}

private fun main(): Unit = runBlocking {
    println("main() running in ${Thread.currentThread().name}")
    launch { delay(10); helloWorld2() }
    launch { helloWorld() }
}
