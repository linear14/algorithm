package ryute.topic03.sub02

import kotlin.math.max

private var n = 0
private lateinit var stair: IntArray
private lateinit var dp: IntArray

private fun main() {

    n = readLine()!!.toInt()
    stair = IntArray(n) { readLine()!!.toInt() }
    dp = IntArray(n)

    dp[0] = stair[0]

    if(n >= 2) {
        dp[1] = stair[0] + stair[1]
    }

    if(n >= 3) {
        dp[2] = max(stair[0], stair[1]) + stair[2]
    }

    for(i in 3 until n) {
        dp[i] = max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i]
    }

    println(dp[n-1])
}