package ryute.topic03.sub02

private lateinit var dp: IntArray

private fun main() {
    val n = readLine()!!.toInt()
    dp = IntArray(n + 1)

    for(current in 2..n) {
        val candidates = mutableListOf<Int>()
        if(current % 3 == 0) {
            candidates.add(dp[current/3])
        }
        if(current % 2 == 0) {
            candidates.add(dp[current/2])
        }
        candidates.add(dp[current - 1])

        dp[current] = candidates.minOrNull()!! + 1
    }
    println(dp[n])
}