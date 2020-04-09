package algorithm_beakjoon

import java.util.*

// 200409
// 2231 - 분해합

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.nextInt()
    var flag = false

    for(num in 1..input) {
        val numToString = num.toString()
        var result = num
        for(i in numToString) {
            result += i.toString().toInt()
        }

        if(result == input) {
            println(num)
            flag = true
            break
        }
    }
    if(!flag) println(0)
}