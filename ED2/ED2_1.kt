package ED2

fun main() {
    print("Digite um número inteiro não negativo: ")
    val input = readLine()
    val n = input!!.toInt()
    if(n > 0) {
        val fatorial = calcularFatorial(n)
        println("$n! = $fatorial")
    }else{
        print("Número é negativo, favor informar um número positivo");
    }
}

fun calcularFatorial(n: Int): Int {
    return if (n == 0) {
        1
    } else {
        n * calcularFatorial(n - 1)
    }
}