package algorithm_beakjoon

// 200326
// 14681 - 사분면 고르기

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val x = sc.nextInt()
    val y = sc.nextInt()

    when {
        x > 0 && y > 0 -> print(1)
        x < 0 && y > 0 -> print(2)
        x < 0 && y < 0 -> print(3)
        x > 0 && y < 0 -> print(4)
    }
}