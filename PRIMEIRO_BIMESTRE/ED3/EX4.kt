package PRIMEIRO_BIMESTRE.ED3

import java.time.LocalTime

open class Conta(
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

    open fun imprimirExtrato() {
        println("=== Extrato ===")
        println("Cliente: $cliente")
        println("Número da conta: $numero")
        println("Agência: $agencia")
        println("Saldo: R$$saldo")
    }
}


class ContaPoupanca(cliente: String,  saldo: Double, numero: String, agencia: String) : Conta (cliente, saldo, numero, agencia){
    fun aplicarJuros() {
        val juros = saldo * 0.003
        depositar(juros)
    }

    override fun imprimirExtrato() {
        super.imprimirExtrato()
        println("Tipo da conta: Poupança")
    }
}

fun main() {
    val contaPoupanca = ContaPoupanca("Erick Krzyzanovski", 1000.0, "121212", "12345")
    println()
    contaPoupanca.depositar(500.0)
    contaPoupanca.retirar(200.0)
    contaPoupanca.aplicarJuros()
    println()
    contaPoupanca.imprimirExtrato()
}
