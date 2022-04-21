package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// even though there's a built-in contract inside isNullOrBlank, we have to define our own
@OptIn(ExperimentalContracts::class)
private fun String?.isNotNullOrBlank(): Boolean {
    contract {
        returns(true) implies (this@isNotNullOrBlank != null)
    }
    return !isNullOrBlank()
}

private fun main() {
    val name: String? = "Kotlin"
    if (name.isNotNullOrBlank()){
        println("name is ${name.length} characters long")
    }
}