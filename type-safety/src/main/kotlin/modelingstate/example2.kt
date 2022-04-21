package modelingstate

// Note using the Result type, which is Kotlin built-in, BUT instructor recommends own implementation due to some
// strange Kotlin edge cases, OR use Arrow::Core
private fun loadUser(name: String): Result<User> = Result.success(User(name))

private fun main() {
    val userResult = loadUser("Name")

    // We can use the fold method
    userResult.fold(
        onSuccess = { user ->
            // smart casting works for us
            println("User's name was ${user.name}")
        },
        onFailure = { error ->
            println("Failed to load user: ${error.message}")
        }
    )

    userResult.isSuccess
    userResult.isFailure

    userResult.onFailure { }
    userResult.onSuccess { user -> println(user.name) }
}
