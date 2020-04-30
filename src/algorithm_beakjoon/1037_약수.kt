package src.algorithm_beakjoon

import java.util.*

// 200430
// 1037 - 약수

fun main() {
    val sc = Scanner(System.`in`)
    val count = sc.nextInt()
    val numbers = mutableListOf<Int>()

    repeat(count) { numbers.add(sc.nextInt()) }
    print(numbers.max()!!.times(numbers.min()!!))
}