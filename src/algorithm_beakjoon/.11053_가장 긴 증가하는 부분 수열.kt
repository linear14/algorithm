package src.algorithm_beakjoon

// 200523
// 11053 - 가장 긴 증가하는 부분 수열 (LIS)

/*
        고생 많이 했음.. dp.max()를 사용하는 방식을 취하는게 맞는건가에 대한 의문이 아직까지 남아있다.
 */
fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map{ it.toInt() }
    val dp = Array(n){ 0 }

    for(index in 0 until n) {
        if(dp[index] == 0) dp[index] = 1
        for(i in 0 until index) {
            if(nums[index] > nums[i]) {
                if(dp[index] <= dp[i]) dp[index] = dp[i] + 1
            }
        }
    }
    print(dp.max())
}

/*

// 반례 12
// 1 2 3 4 5 4 3 2 1 2 3 4

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map{ it.toInt() }
    val dp = Array(n){ 0 }

    for(index in 0 until n) {
        if(dp[index] == 0) dp[index] = if (index == 0) 1 else dp[index-1]
        for(i in 0 until index) {
            if(nums[index] > nums[i]) {
                if(dp[i] >= dp[index]) dp[index] = dp[i] + 1
            }
        }
    }
    print(dp[n-1])
}
*/

/*
// 반례 1 2 1 1 1 1

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map{ it.toInt() }
    val dp = Array(n){ 0 }

    for(index in 0 until n) {
        if(dp[index] == 0) dp[index] = 1
        for(i in 0 until index) {
            if(nums[index] > nums[i]) {
                if(dp[i] >= dp[index]) dp[index] = dp[i] + 1
            }
        }
    }
    print(dp[n-1])

}*/


/*
// 반례 1 4 2 3

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map{ it.toInt() }
    val list = mutableListOf<Pair<Int,Int>>()

    for(num in nums) {
        for((index, pair) in list.withIndex()) {
            if(pair.first < num) {
                list[index] = Pair(num, pair.second + 1)
            }
        }
        list.add(Pair(num, 1))
    }

    val max = list.maxBy{ it.second }!!.second
    print(max)
}*/
