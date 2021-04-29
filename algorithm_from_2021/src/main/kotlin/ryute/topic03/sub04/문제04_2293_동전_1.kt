package ryute.topic03.sub04

// 2차원 배열로 만들 필요가 없음
// 메모리 관련 문제가 나오면.. 1차원 배열로 해결할 수 있는지를 항상 고려!

// 본 문제에서는 dp를 사용하면서, 이전 행의 같은 열 원소를 그대로 가져올 수 있기 때문에 (+= 사용해서) 1차원 배열 가능

private fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val ks = IntArray(n + 1) { if(it != 0) readLine()!!.toInt() else 0 }
    val dp = IntArray(k + 1)

    ks.sort()
    dp[0] = 1

    for(t in ks.indices) {
        if(t == 0) continue
        for(i in 1..k) {
            if(i - ks[t] < 0) continue
            dp[i] += dp[i-ks[t]]
        }

        /*for(i in 0..k) {
            print("${dp[i]} ")
        }
        println()*/
    }

    println(dp[k])
}