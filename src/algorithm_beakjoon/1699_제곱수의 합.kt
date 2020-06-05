package src.algorithm_beakjoon

import kotlin.math.sqrt

// 200605
// 1699 - 제곱수의 합

/*
      그리디 알고리즘이 아니다.
      예를 들어,
      117 같은 경우 : 10^2 + 4^2 + 1^2 으로 3이 될 수도 있지만
                    9^2 + 6^2 으로부터 나온 2가 정답이기 때문이다.


      풀이는 다음과 같다.

      가령, i = 11 일 경우를 예로 들면
      1 ~ 10까지의 경우에서는 dp가 구해져 있는 상태.

      11 일 경우 : 1, 4, 9 보다 크기 때문에
      11 - 9 = 2에서의 dp (dp[2])
      11 - 4 = 7에서의 dp (dp[7])
      11 - 1 = 10에서의 dp (dp[10]) 을 각각 구한 뒤,
      그 때의 최소값을 확인해준다.

      위에서는 최소값이 dp[2] 혹은 dp[10] 이므로
      그 값에 1을 더해준 값이 dp[11]이 된다.

*/

fun main() {
    val n = readLine()!!.toInt()
    val dp = Array(n + 1){ 0 }

    for(i in 1..n) {
        var min = Integer.MAX_VALUE
        for(j in sqrt(i.toDouble()).toInt() downTo 1) {
            val temp = dp[i - (j * j)]
            if(temp < min) min = temp
        }
        dp[i] = dp[min] + 1
    }

    print(dp[n])
}
