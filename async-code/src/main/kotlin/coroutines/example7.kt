package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

val context = newSingleThreadContext("Custom Context")

suspend fun makeNetworkRequest() = withContext(Dispatchers.IO) {
    println("longRunningTask() running on : ${Thread.currentThread().name}")
    delay(5000)
    updateUI("Kotlin")
}

suspend fun updateUI(name: String) {
    println("updateUI running on ${Thread.currentThread().name}")
}

fun main(): Unit = runBlocking(context) {
    println("main() running on: ${Thread.currentThread().name}")
    launch { makeNetworkRequest() }
    cancel()
}

