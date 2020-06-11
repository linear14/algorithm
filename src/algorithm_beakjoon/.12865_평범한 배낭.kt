package src.algorithm_beakjoon

import kotlin.math.max

// 200611
// 12865 - 평범한 배낭
// https://huiyu.tistory.com/entry/DP-01-Knapsack%EB%B0%B0%EB%82%AD-%EB%AC%B8%EC%A0%9C

/*

        이런 사고를 할 수 있어야 한다.
        엄청 유명한 문제라고 하는데, 일명 0/1 knapsack 문제이다.

        이차원 배열을 이용하여 문제에 접근한다.
        행에는 0 ~ n, 열에는 0 ~ k를 배치한다.
        각각 몇 개의 가방까지를 허용하냐, 얼마만큼의 무게까지 감당 가능하느냐를 의미한다.

        상황의 축소를 이용하여 dp 값을 계속 구한다.
        a행의 b열의 dp 값을 구하고 싶다고 가정하자
        이 dp값의 의미는 a개의 가방까지를 가지고 있을 때, b의 무게까지 허용 하는 상황에서 최대의 가치는 얼마인지를 물어보는 것이다.

        이런식으로 생각해 볼 수 있겠다.
        우리는 a-1개의 가방까지를 가지고 있을 때의 각 값을 이미 이전 행의 dp에서 구한 상태이다.

        1) a번째 가방을 선택했을 경우
        2) a번째 가방을 선택하지 않았을 경우
        로 나누어 생각해보면,

        1)의 경우.. b의 값 (허용 가능한 무게) 에서 a번째 가방의 무게를 뺐을 때,
        그 값이 0보다 작다면 이 가방은 선택이 불가능 한 가방이고, 동일 무게에서의 이전의 최대치를 dp의 값으로 가진다. (dp[a][b] = dp[a-1][b])
        만약, 그 값이 0보다 크거나 같다면, 이 가방은 선택 가능한 가방이다.
        즉, 이 때 선택한 경우(1)와 선택하지 않은 경우(2) 에서의 최대값을 dp의 값으로 택해주면 된다.
        선택하지 않은 경우에는 이전의 최대값이 정답 후보고
        선택한 경우는 현재 가방을 선택했을 때의 가치 + a-1의 경우에서 남은 무게에서의 dp값이 정답 후보이다.
        (dp[a][b] = max(dp[a-1][b], bags[a]의 가치 + dp[a-1][남은무게]))

        자세한 것은 아래 식을 보면서 생각해보던, 위에 있는 블로그 링크에서 공부하면 된다.

 */


fun main() {
    val (n, k) = readLine()!!.split(" ").map{ it.toInt() }
    val bags = Array(n) { readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    val dp = Array(n + 1){ Array(k + 1) { 0 } }

    for(i in 1..n) {
        for(j in 1..k) {
            val remain = j - bags[i-1][0]
            if(remain < 0) dp[i][j] = dp[i-1][j]
            else dp[i][j] = max(dp[i-1][j], bags[i-1][1] + dp[i-1][remain])
        }
    }

    print(dp[n][k])
}