package ED2

fun main() {
    print("Digite o valor monetário: ")
    val valor = readLine()!!.toDouble()

    val moedas = mapOf(
        "1 real" to 100,
        "50 centavos" to 50,
        "25 centavos" to 25,
        "10 centavos" to 10,
        "5 centavos" to 5,
        "1 centavo" to 1
    )

    var valorRestante = (valor * 100).toInt()
    var totalMoedas = 0

    for ((nomeMoeda, valorMoeda) in moedas) {
        val qtdeMoedas = valorRestante / valorMoeda
        if (qtdeMoedas > 0) {
            totalMoedas += qtdeMoedas
            valorRestante -= qtdeMoedas * valorMoeda
            println("$qtdeMoedas moedas de $nomeMoeda")
        }
    }

    println("Número mínimo de moedas: $totalMoedas")
}