package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// from example5
// sealed class State {
//     object Loading: State()
//     data class Success(val msg: String): State()
//     object Error: State()
// }

@OptIn(ExperimentalContracts::class)
private fun State?.requireSuccess(): Boolean {
    contract {
        returns() implies (this@requireSuccess is State.Success)
    }
    return if (this is State.Success) true else throw IllegalStateException()
}

private fun main() {
    val state: State? = State.Success("success!")

    if (!state.requireSuccess()) return

    // now the smart cast works
    println(state.msg)
    // and we don't need to explicitly cast
    // println((state as State.Success).msg)
}
