package ED2

fun main() {
    for (n in 0..10) {
        var fatorial = 1
        for (i in 1..n) {
            fatorial *= i
        }
        println("$n! = $fatorial")
    }
}