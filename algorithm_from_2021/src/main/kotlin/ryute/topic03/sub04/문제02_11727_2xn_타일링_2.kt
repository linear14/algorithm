package ryute.topic03.sub04

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val dp = IntArray(n + 1)

    dp[1] = 1
    if(n != 1) dp[2] = 3

    for(i in 3..n) {
        dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007
    }
    bw.write(dp[n].toString())
    bw.flush()
    bw.close()
}