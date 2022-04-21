package contracts

// look, there's a built-in contract inside isNullOrBlank
private fun String?.isNotNullOrBlank() = !isNullOrBlank()

private fun main() {
    val name: String? = "Kotlin"
    if(name.isNotNullOrBlank()){
        // but contracts aren't transitive so compiler error again unless we ?. or !!
        println("name is ${name!!.length} characters long")
    }
}