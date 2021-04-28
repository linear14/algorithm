package ryute.topic03.sub04

private fun main() {

    val n = readLine()!!.toInt()
    val dp = IntArray(n + 1)
    dp[1] = 1
    if(n != 1) dp[2] = 2

    for(i in 3..n) {
        dp[i] = (dp[i-2] + dp[i-1]) % 10007
    }

    println(dp[n])
}