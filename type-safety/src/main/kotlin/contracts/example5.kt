package contracts

sealed class State {
    object Loading : State()
    data class Success(val msg: String) : State()
    object Error : State()
}

private fun State?.requireSuccess(): Boolean {
    return if (this is State.Success) true else throw IllegalStateException()
}

private fun main() {
    val state: State? = State.Success("success!")

    if (!state.requireSuccess()) return

    // doesn't work, but "we" know it should
    // println(state.msg)
    println((state as State.Success).msg)
}
