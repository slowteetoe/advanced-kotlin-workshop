package modelingstate

private fun loadUser(name: String): User? = User(name)

private fun main() {
    val user = loadUser("Nate")
    if (user != null) {
        println("users name was ${user.name}")
    }
}
