fun main() {
    println("Bem vindo ao Bytebank")
    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.deposita(200.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    val contaFran = Conta(titular = "Fran", numero = 1001)
    contaFran.deposita(valor = 300.0)
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta de Alex")
    contaAlex.deposita(valor = 70.0)
    println(contaAlex.saldo)
    println("Depositando na conta da Fran")
    contaFran.deposita(valor = 50.0)
    println(contaFran.saldo)

    println("Sacando da conta do Alex")
    contaAlex.saca(valor = 250.0)
    println(contaAlex.saldo)
    println("Sacando da conta da Fran")
    contaFran.saca(valor = 100.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")
    if (contaFran.transfere(valor = 100.0, destino = contaAlex)) {
        println("Transferência sucedida")
    } else {
        println("Falha na Transferência")
    }
    println(contaAlex.saldo)
    println(contaFran.saldo)
}

class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        when {
            valor > 0 -> this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        when {
            saldo >= valor ->
                saldo -= valor
            else -> println("Saque em excesso, você não tem dinheiro para esse saque")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        when {
            saldo >= valor -> {
                saldo -= valor
                destino.saldo += valor
                return true
            }
            else -> return false
        }
    }

}

//    Códigos para fins didáticos

//fun testaLaços() {
//
//    val titular = "Renato"
//    val numeroConta = 1000
//    var saldoConta = 0.0
////    saldoConta = 200 + 2.0
////    saldoConta += 100
//
//    println("Titular $titular")
//    println("Numero da conta $numeroConta")
//    println("Saldo $saldoConta")
//
//}
//
//fun testaCondições(saldoConta: Double) {
//    when {
//        saldoConta > 0.0 -> println("Saldo da sua conta é positiva")
//        saldoConta == 0.0 -> println("Saldo da sua conta é neutra")
//        else -> println("Saldo da sua conta é negativa")
//    }
//}

//    fun getSaldo(): Double {
//        return saldo
//    }
//    fun setSaldo(valor: Double){
//        saldo = valor
//    }

//constructor(titular: String, numero: Int){
//    this.titular  = titular
//    this.numero = numero
//}