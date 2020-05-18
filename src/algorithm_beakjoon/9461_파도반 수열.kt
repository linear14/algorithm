package src.algorithm_beakjoon

// 200518
// 9461 - 파도반 수열

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val ans = Array(101){ 0L }
        ans[1] = 1
        ans[2] = 1
        ans[3] = 1
        ans[4] = 2
        ans[5] = 2
        for(i in 6..n) ans[i] = ans[i - 5] + ans[i - 1]
        println(ans[n])
    }
}