package algorithm_beakjoon

import java.util.*

// 200406
// 3053 - 택시 기하학

fun main() {
    val sc = Scanner(System.`in`)
    val r = sc.nextInt()

    println(String.format("%.6f", Math.PI * r * r))
    println(String.format("%.6f", 2 * r * r.toDouble()))
}