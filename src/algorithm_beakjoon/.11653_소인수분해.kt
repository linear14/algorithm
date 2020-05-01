package src.algorithm_beakjoon

import java.lang.StringBuilder
import java.util.*

// 200501
// 11653 - 소인수분해

fun main() {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()

    if(n == 1) return
    var divide = 2

    val builder = StringBuilder()

    while(divide <= n) {
        if(n % divide == 0) {
            n /= divide
            builder.append("$divide\n")
        } else divide++
    }

    if(builder.isEmpty()) print(n)
    else print(builder.toString())

}