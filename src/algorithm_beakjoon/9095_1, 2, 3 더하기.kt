package src.algorithm_beakjoon

// 200524
// 9095 - 1, 2, 3 더하기

fun main() {
    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()
        val dp = Array(n + 1){ 0 }

        dp[1] = 1
        if(n >= 2) dp[2] = 2
        if(n >= 3) dp[3] = 4

        for(i in 4..n) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
        }

        println(dp[n])
    }
}