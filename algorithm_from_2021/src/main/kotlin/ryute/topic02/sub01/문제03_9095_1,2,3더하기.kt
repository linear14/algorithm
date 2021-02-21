package ryute.topic02.sub01

private var array: Array<Int> = arrayOf()
private var n: Int = 0
private var ans = 0

private fun main() {
    val t = readLine()!!.toInt()

    repeat(t) {
        n = readLine()!!.toInt()

        // SOLUTION - BackTracking
        /*array = Array(n) { 0 }
        ans = 0

        backTracking(0)
        println(ans)*/

        // SOLUTION - Dynamic Programming
        println(solutionWithDP(n))
    }
}

private fun backTracking(level: Int) {
    var sum = 0
    for(i in array) {
        sum += i
    }

    if(sum == n) {
        ans++
        return
    }

    if(sum > n) {
        return
    }

    for(i in 1..3) {
        array[level] = i
        backTracking(level + 1)
        array[level] = 0
    }
}

private fun solutionWithDP(n: Int): Int {

    val dp = Array(n + 1) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for(i in 4..n) {
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    }

    return dp[n]
}