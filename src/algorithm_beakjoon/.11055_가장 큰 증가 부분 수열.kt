package src.algorithm_beakjoon

// 200605
// 11055 - 가장 큰 증가 부분 수열

fun main() {
    val n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()
    val dp = Array(n){ i -> array[i] }

    for(i in array.indices) {
        for(j in 0 until i) {
            if(array[i] > array[j] && dp[i] < dp[j] + array[i]) {
                dp[i] = dp[j] + array[i]
            }
        }
    }
    println(dp.max())
}
