package PRIMEIRO_BIMESTRE.ED3

class EX1(
    val cliente: String,
    var saldo: Double,
    val numero: String,
    val agencia: String
) {
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

    fun transferir(valor: Double, contaDestino: EX1) {
        if (saldo >= valor) {
            saldo -= valor
            contaDestino.saldo += valor
            println("Transferência de R$$valor realizada com sucesso!")
        } else {
            println("Saldo insuficiente para realizar a transferência.")
        }
    }

    fun imprimirExtrato() {
        println("=== Extrato ===")
        println("Cliente: $cliente")
        println("Número da conta: $numero")
        println("Agência: $agencia")
        println("Saldo: R$$saldo")
        println()
    }

}

fun main() {
    val conta1 = EX1("Erick Krzyzanovski", 1000.0, "121212", "12345")
    val conta2 = EX1("Joaozinho da Silva", 500.0, "321321", "54321")

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

    conta1.depositar(400.0)

    conta1.retirar(300.0)

    conta1.transferir(300.0, conta2)

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()
}