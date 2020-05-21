package src.algorithm_beakjoon

import kotlin.math.max

// 200521
// 2579 - 계단 오르기

fun main() {
    val n = readLine()!!.toInt()
    val steps = Array(n){ readLine()!!.toInt() }
    val dp = Array(n){ Array(2){ 0 } }

    dp[0][1] = steps[0]
    if(n > 1) {
        dp[1][0] = steps[1]
        dp[1][1] = steps[0] + steps[1]
    }

    for(i in 2 until n) {
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + steps[i]
        dp[i][1] = dp[i - 1][0] + steps[i]
    }

    print(max(dp[n - 1][0], dp[n - 1][1]))
}