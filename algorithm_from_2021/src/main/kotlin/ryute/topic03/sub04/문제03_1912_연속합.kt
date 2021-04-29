package ryute.topic03.sub04

import kotlin.math.max

// 0: 내가 포함된 경우
// 1: 내가 포함되지 않은 경우
private fun main() {
    val n = readLine()!!.toInt()
    val table = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array(n) { IntArray(2) }
    dp[0] = intArrayOf(table[0], Int.MIN_VALUE)

    for(i in 1 until n) {
        dp[i][0] = max(dp[i-1][0] + table[i], table[i])
        dp[i][1] = max(dp[i-1][0], dp[i-1][1])
    }

    println(max(dp[n-1][0], dp[n-1][1]))
}