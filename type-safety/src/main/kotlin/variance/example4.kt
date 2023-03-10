package variance
private class ValueExchange<in T : ValueStore, out K : ValueStore> {
    fun send(value: T): Unit = TODO()
    fun receive(): K = TODO()
}

private fun main() {
    var exchange: ValueExchange<USD, STOCK> = ValueExchange()

    exchange = ValueExchange<FIAT, APPL>()

    exchange.send(USD())
    val stock: STOCK = exchange.receive()
}
