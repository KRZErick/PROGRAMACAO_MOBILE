package ED2

import java.lang.Exception

fun main(){
    try {
        print("Informe o primeiro número: ")
        val n1 = readLine()!!.toDouble()
        print("Informe o segundo número: ")
        val n2 = readLine()!!.toDouble()
        print("Informe o terceiro número: ")
        val n3 = readLine()!!.toDouble()

        val listN = listOf(n1, n2, n3).sorted()
        print("Os números informados em ordem crescente: $listN")
    }catch (e: Exception){
        print("O caracter informado nâo é um número")
    }

}