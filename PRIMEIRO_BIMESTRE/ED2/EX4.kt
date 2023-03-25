package PRIMEIRO_BIMESTRE.ED2

import java.lang.Exception

fun main(){
        try {
            print("Informe a primeira nota: ")
            val nota1 = readLine()!!.toDouble()
            print("Informe a segunda nota: ")
            val nota2 = readLine()!!.toDouble()
            print("Informe a terceira nota: ")
            val nota3 = readLine()!!.toDouble()

            val media = (nota1*2 + nota2*3 + nota3*5)/10

            if(media > 70){
                print("Aluno Aprovado com média $media")
            }else if(media > 40){
                print("Aluno para exame final")
            }else{
                print("Aluno reprovado")
            }

        }catch (e: Exception){
            print("O caracter informado nâo é um número")
        }
    }