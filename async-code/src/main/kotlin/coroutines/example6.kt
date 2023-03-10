package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {

    // create coroutine using dispatcher inherited from current Coroutine scope
    launch {
        println("launch(){} - thread name = ${Thread.currentThread().name}")
    }

    // create coroutine using dispatcher specified... Dispatchers.Default is backed by shared thread pool
    launch(Dispatchers.Default) {
        println("launch(Dispatchers.Default){} - thread name = ${Thread.currentThread().name}")

        launch {
            println("launch(Default) - child launch {} - thread name = ${Thread.currentThread().name}")
        }
    }

    launch(Dispatchers.IO) {
        println("launch(Dispatchers.IO){} - thread name = ${Thread.currentThread().name}")
    }

    }