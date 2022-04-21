package contracts

private fun Any?.isNull() = this == null

private fun main(){
    val name: String? = "Kotlin"
    // we know that name is not null after this point, because we checked, but the compiler doesn't
    if(name.isNull()) return

    // ick, see example2.kt for a way to eliminate !! by using contract
    println("name is ${name!!.length} characters long")
}