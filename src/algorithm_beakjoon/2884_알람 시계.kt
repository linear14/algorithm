package algorithm_beakjoon

// 200326
// 2884 - 알람 시계

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var hour = sc.nextInt()
    var min = sc.nextInt()

    if(min < 45) {
        if(hour == 0) hour = 23
        else hour--
        min += 15
    } else {
        min -= 45
    }

    print("$hour $min")
}