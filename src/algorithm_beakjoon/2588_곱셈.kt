package algorithm_beakjoon

// 200324
// 2588 : 곱셈

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val line1 = input.nextInt()
    val line2 = input.nextInt()

    val line3 = line1 * (line2 % 10)
    val line4 = line1 * (line2 % 100 - line2 % 10)
    val line5 = line1 * (line2 % 1000 - line2 % 100)
    val line6 = line3 + line4 + line5

    println(line3)
    println(line4 / 10)
    println(line5 / 100)
    println(line6)
}