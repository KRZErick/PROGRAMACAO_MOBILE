package PRIMEIRO_BIMESTRE.ED3

class EX2 (
    val cliente: String,
    var saldo: Double,
    val numero: String,
    val agencia: String

){
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

    fun transferir(valor: Double, contaDestino: EX2) {
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
    val conta1 = EX2("Erick Krzyzanovski", 1000.0, "121212", "12345")
    val conta2 = EX2("Joaozinho da Silva", 500.0, "321321", "54321")


    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

    //Conta1
    println("Operaçôes Conta 01 ")
    conta1.depositar(400.0)
    conta1.retirar(300.0)
    conta1.transferir(300.0, conta2)
    println()

    //Conta2
    println("Operaçôes Conta 02 ")
    conta2.depositar(500.0)
    conta2.retirar(1000.0)
    conta2.transferir(400.0, conta1)
    println()

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()
}