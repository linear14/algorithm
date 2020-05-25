package src.algorithm_beakjoon

// 200525
// 11051 - 이항 계수 2

fun main() {
    val (n, k) = readLine()!!.split(" ").map{ it.toInt() }
    val dp = Array(n + 1){ i -> IntArray(i + 1){ 1 } }

    for(i in 2..n) {
        for(j in 1 until dp[i].size - 1) {
            dp[i][j] = (dp[i-1][j-1] % 10007 + dp[i-1][j] % 10007) % 10007
        }
    }
    print(dp[n][k])
}