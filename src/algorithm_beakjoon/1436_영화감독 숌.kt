package algorithm_beakjoon

import java.util.*

// 200411 ~ 200415
// 1436 - 영화감독 숌

fun main() {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var num = 666

    while(n > 0) {
        if("666" in num.toString()) {
            n--
        }
        if(n == 0) {
            println(num)
        }
        num++
    }
}