package PRIMEIRO_BIMESTRE.ED3

interface Boleto {
    fun imprimirBoleto(valor: Double)
}

open class EX5Conta(val cliente: String) : Boleto{
    override fun imprimirBoleto(valor: Double) {
        println("==== Boleto ====")
        println("Cliente: $cliente")
        println("Valor: R$ $valor")
        println()
        println("Codigo de pagamento")
        println("12345.1235.12345.12345.12345")
        println("|||||||||||||||||||||||||||||")
    }
}

fun main(){
    val minhaConta = EX5Conta("Erick Krzyzanovski")
    minhaConta.imprimirBoleto(100.0)
}