package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
private fun State.setup(config: State.() -> Unit) {

    contract{
        callsInPlace(config, InvocationKind.EXACTLY_ONCE)
    }
    config()
}

private fun main() {
    val state: State = State.Success("Hello Kotlin!")
    val screenTitle: String

    state.setup {
        // compiler won't allow this "Captured values initialization is forbidden due to possible reassignment" because
        // it doesn't know the lambda won't be caused more than once.
        // But now that we have the contract that says it will be invoked EXACTLY_ONCE, compiler can allow it
        screenTitle = if (this is State.Success) msg else ""
    }

    println(screenTitle)
}