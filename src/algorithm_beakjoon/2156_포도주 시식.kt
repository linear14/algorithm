package src.algorithm_beakjoon

import kotlin.math.max

// 200523
// 2156 - 포도주 시식

/*
        1. 2579 계단 오르기 문제와 유사하지만 시작점과 끝점을 무조건 지나야 한다는 말이 없음
        2. 따라서, 그 지점을 지나지 않을 경우까지 처리를 해 주어야 함
        3. 또한, 포도주를 연속해서 2개 안 마실수도 있으므로, 고려해주어 처리
 */

fun main() {
    val n = readLine()!!.toInt()
    val juices = Array(n){ readLine()!!.toInt() }

    val answer = Array(n + 1){ Array(3){ 0 } }
    answer[1][2] = juices[0]
    if(n > 1) {
        answer[2][1] = juices[1]
        answer[2][2] = juices[0] + juices[1]
    }

    for(i in 3..n) {
        answer[i][0] = answer[i-3].max()!! + juices[i-1]
        answer[i][1] = answer[i-2].max()!! + juices[i-1]
        answer[i][2] = max(answer[i-1][0], answer[i-1][1]) + juices[i-1]
    }

    print(max(answer[n-1].max()!!, answer[n].max()!!))
}