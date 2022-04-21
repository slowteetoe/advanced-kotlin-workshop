package modelingstate

import arrow.core.Either

private fun loadUser(name: String): Either<IllegalArgumentException,User> {
    return if (name.isEmpty()) {
        Either.Left(IllegalArgumentException("name param must not be null"))
    } else {
        Either.Right(User(name))
    }
}

private fun main() {
    when(val result = loadUser("Nate")){
        is Either.Left -> println(result.value)
        is Either.Right -> println("User's name was ${result.value}")
    }

    // or use fold(..) again 
}
