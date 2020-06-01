package src.algorithm_beakjoon

// 200601
// 1010 - 다리 놓기

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val dp = Array(m + 1){ i -> IntArray(i + 1){ 1 } }

        for(i in 2..m) {
            for(j in 1 until i) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            }
        }

        println(dp[m][n])
    }
}