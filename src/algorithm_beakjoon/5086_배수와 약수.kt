package src.algorithm_beakjoon

import java.util.*

// 200430
// 5086 - 배수와 약수

fun main() {
    val sc = Scanner(System.`in`)
    a@while(true) {
        var first = sc.nextInt()
        var second = sc.nextInt()

        val fixFirst = first
        val fixSecond = second

        if(first == 0 && second == 0) break

        if(first < second) {
            while(first < second) {
                first += fixFirst
                if(first == second) {
                    println("factor")
                    continue@a
                }
            }
        } else {
            while(first > second) {
                second += fixSecond
                if(first == second) {
                    println("multiple")
                    continue@a
                }
            }
        }
        println("neither")
    }
}