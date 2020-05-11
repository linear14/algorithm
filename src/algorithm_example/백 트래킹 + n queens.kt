package src.algorithm_example

import java.util.*
import kotlin.math.abs

// 200511
// 백트래킹 예제 연습
// https://bumbums.tistory.com/3

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()    // n을 입력하면, n*n 체스판에서 n개의 queen을 두었을 경우, 각 퀸이 서로를 공격하지 않을 때의 위치를 모두 출력한다.
    val cols = Array(n){ 0 }

    fun isPossible(level: Int): Boolean {
        // 0층부터 조사하는 층 이전까지 두어진 말의 위치와, 조사하는 층의 두어진 말의 위치를 비교하여
        // 둘 수 있는 위치인지 아닌지를 조사한다.
        for(i in 0 until level) {
            if(cols[i] == cols[level] || abs(cols[level] - cols[i]) == level - i) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        // 우선, level은 n-1 까지가 최대치다. (가령, n=5라면 level로 가능한 값은 0,1,2,3,4 이기 때문)
        // 즉, level이 n과 같아졌다는 말은, 모든 층을 다 조사했다는 의미가 되므로,
        // 각 층에 세워진 말의 위치를 순서대로 출력해주면 된다.
        if(level == n) {
            for(i in cols) print(i)
            println()
        } else {

            //여기가 backTracking 의 핵심 부분
            for(i in 0 until n) {
                cols[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
}