package ryute.topic03.sub04

import kotlin.math.max

private fun main() {
    val n = readLine()!!.toInt()
    val table = Array(n) { readLine()!!.toInt() }
    val dp = IntArray(n)

    dp[0] = table[0]
    if(n >= 2) { dp[1] = table[0] + table[1] }
    if(n >= 3) { dp[2] = max(max(dp[0] + table[2], table[1] + table[2]), dp[1]) }

    for(i in 3 until n) {
        val includeMax = max(dp[i-2] + table[i], dp[i-3] + table[i-1] + table[i])
        val excludeMax = dp[i-1]
        dp[i] = max(includeMax, excludeMax)
    }

    println(dp[n-1])
}