package src.algorithm_beakjoon

// 200521
// 1463 - 1로 만들기

/*
        만약 n=10 이라면
        이전의 n=1 ~ n=9 까지의 모든 기록은 dp 배열에 저장되어있음

        즉, 10에서 1을 뺀 연산을 한 번 수행하면 9가 되는데, n=9 일 때의 최소값은 이미 기록이 되어있으므로, 기존 기록 + 1 을 해주면 됨
        다만, 10은 2로 나누어지기 때문에 이 연산을 수행하면 5가 되는데, n=5 일 때의 최소값 역시 기록이 되어 있으므로, 기존 기록 + 1 을 해준다.

        그러면, 첫 case와 두번째 case가 나오는데, 값이 더 작은것을 기록해두면 된다.
 */

fun main() {
    val n = readLine()!!.toInt()
    val dp = Array(n + 1){ 0 }

    for(i in 2..n) {
        var min = dp[i - 1]
        if(i % 3 == 0){
            if(min > dp[i / 3]) {
                min = dp[i / 3]
            }
        }
        if(i % 2 == 0) {
            if(min > dp[i / 2]) {
                min = dp[i / 2]
            }
        }
        dp[i] = min + 1
    }

    print(dp[n])
}