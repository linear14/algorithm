package ryute.topic03.sub04

import kotlin.math.max

private fun main() {
    val n = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }

    val dp = Array(n + 1) { IntArray(n + 1) }

    for(i in 1..n) {
        for(j in 1..n) {
            if(j < i) {
                dp[i][j] = dp[i-1][j]
                continue
            }
            dp[i][j] = max(dp[i-1][j], dp[i][j-i] + cards[i-1])
        }
    }
    println(dp[n][n])
}