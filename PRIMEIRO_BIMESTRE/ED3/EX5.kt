package PRIMEIRO_BIMESTRE.ED3

interface Boleto {
    fun imprimirBoleto(valor: Double)
}

open class EX5Conta(
    val cliente: String,
    var saldo: Double,
    val numero: String,
    val agencia: String
) : Boleto{
    override fun imprimirBoleto(valor: Double) {
        println("==== Boleto ====")
        println("Cliente: $cliente")
        println("Valor: R$ $valor")
        println()
        println("Codigo de pagamento")
        println("12345.1235.12345.12345.12345")
        println("|||||||||||||||||||||||||||||")
    }

    fun depositar(valor: Double) {
        saldo += valor
        println("Depósito de R$$valor realizado com sucesso!")
    }

    fun retirar(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
            println("Saque de R$$valor realizado com sucesso!")
        } else {
            println("Saldo insuficiente para realizar o saque.")
        }
    }

    fun transferir(valor: Double, contaDestino: EX5Conta) {
        if (saldo >= valor) {
            saldo -= valor
            contaDestino.saldo += valor
            println("Transferência de R$$valor realizada com sucesso!")
        } else {
            println("Saldo insuficiente para realizar a transferência.")
        }
    }

    open fun imprimirExtrato() {
        println("=== Extrato ===")
        println("Cliente: $cliente")
        println("Número da conta: $numero")
        println("Agência: $agencia")
        println("Saldo: R$$saldo")
    }
}


fun main(){
    val minhaConta = EX5Conta("Erick Krzyzanovski", 1000.0, "121212", "12345")
    minhaConta.imprimirBoleto(100.0)
}