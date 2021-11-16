package self_boj

private fun main() {
    val (n, c) = readLine()!!.split(" ").map { it.toInt() }
    val w = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()

    val dp = Array(n + 1) { IntArray(c + 1) { 0 } }

    var ans = 1
    for(i in 1..n) {
        for(j in 1..c) {
            if(w[i-1] <= j) {
                dp[i][j] = dp[i-1][j-w[i-1]] + w[i-1]
                if(dp[i][j] != dp[i][j-1]) {
                    ans++
                }
            } else {
                dp[i][j] = dp[i-1][j]
            }
        }
    }

    print(ans)
}