package org.example


fun main() {
    runCheckSudoku()
    runCheckIpv4()

}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) println("success : $name")
    else println("fail : $name")
}



