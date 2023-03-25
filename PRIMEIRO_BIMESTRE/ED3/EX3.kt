package PRIMEIRO_BIMESTRE.ED3

class EX3(val cliente: String, var saldo: Double, var numero: String, var agencia: String)
    val contas = listOf(
            EX3("Erick Krzyzanovski", 1000.0, "121212", "12345")
        ,   EX3("Joaozinho da Silva", 500.0, "321321", "54321")
        ,   EX3("Pedro do Pedro", 13400.0, "345345", "65432")
        ,   EX3("Moises da Silva", 2340.0, "745674", "76543")
        ,   EX3("Maicon da Silva", 5440.0, "967876", "23456")
    )

    fun main(){
        val contasPorSaldo = contas.sortedBy { it.saldo }

        println("Contas em ordem crescente do menor para o maior saldo:")
        contasPorSaldo.forEach { contas ->
            println("${contas.cliente} - Saldo: ${contas.saldo}")
        }

        val contasPorNome = contas.sortedBy { it.cliente }

        println("\nContas em ordem alfabética pelo nome do cliente:")
        contasPorNome.forEach { contas ->
            println("${contas.cliente} - Saldo: ${contas.saldo}")
    }
}
