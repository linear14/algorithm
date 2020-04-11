package algorithm_beakjoon

import java.util.*

// 200411
// 2163 - 초콜릿 자르기

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    print((n - 1) + (n * (m - 1)))

}