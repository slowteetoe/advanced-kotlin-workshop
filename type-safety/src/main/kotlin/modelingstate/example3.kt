package modelingstate

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

private fun loadUser(name: String): Option<User> = Some(User(name))

// Arrow Core
// https://arrow-kt.io/docs/core/

private fun main() {
    when (val result = loadUser("Nate")) {
        None -> println("No user exists")
        is Some -> println("User's name was ${result.value}")
    }
}
