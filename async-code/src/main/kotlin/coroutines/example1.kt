package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private suspend fun helloWorld() {
    println("Hello World!")
}

private fun main() {
    GlobalScope.launch {
        helloWorld()
    }
}
