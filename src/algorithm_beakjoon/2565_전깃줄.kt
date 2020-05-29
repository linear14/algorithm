package src.algorithm_beakjoon

// 200530
// 2565 - 전깃줄

/*
        함수라고 생각하면
        모든 치역의 값이 증가하는 꼴로 가야됨.
 */

fun main() {
    val n = readLine()!!.toInt()
    val lines = Array(n){ Pair(0, 0) }
    val dp = Array(n){ 1 }

    for(i in 0 until n) {
        val (a, b) = readLine()!!.split(" ").map{ it.toInt() }
        lines[i] = Pair(a, b)
    }

    lines.sortBy{ it.first }

    for(i in 0 until n) {
        for(j in 0 until i) {
            if(lines[i].second > lines[j].second && dp[i] <= dp[j]) {
                dp[i] = dp[j] + 1
            }
        }
    }

    print(n - dp.max()!!)
}