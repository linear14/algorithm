package self_boj

import kotlin.math.max

private fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val items = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n + 1) { IntArray(k + 1) { 0 } }

    for(i in 1..n) {
        for(j in 1..k) {
            // 현재 아이템의 무게가 배낭의 전체 용량보다 클 경우
            val max = if(j < items[i - 1][0]) {
                dp[i -1][j]
            } else {
                max(dp[i - 1][j - items[i - 1][0]] + items[i - 1][1], dp[i - 1][j])
            }
            dp[i][j] = max
        }
    }
    print(dp[n][k])
}