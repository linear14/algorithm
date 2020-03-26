package algorithm_beakjoon

// 200326
// 2753 - 윤년

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val year = sc.nextInt()

    when {
        year % 400 == 0 -> print(1)
        year % 100 == 0 -> print(0)
        year % 4 == 0 -> print(1)
        else -> print(0)
    }
}