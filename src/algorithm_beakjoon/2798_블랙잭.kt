package algorithm_beakjoon

import java.util.*

// 200408
// 2798 - 블랙잭

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val numbers = Array(n){ sc.nextInt() }
    var max = -1

    for(first in 0 until numbers.size - 2) {
        for(second in first + 1 until numbers.size - 1) {
            for(third in second + 1 until numbers.size) {
                val sum = numbers[first] + numbers[second] + numbers[third]
                if(sum in (max + 1)..m) {
                    max = sum
                }
            }
        }
    }
    print(max)
}
