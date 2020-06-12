package src.algorithm_beakjoon

import java.util.*

// 200612
// 2178 - 미로 탐색

fun main() {
    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val board = Array(n + 2){ Array(m + 2) { 0 } }
    val visit = Array(n + 2){ Array(m + 2) { 0 } }

    val q = LinkedList<IntArray>() // IntArray의 값 :::: 0번 인덱스 : n값, 1번 인덱스 : m값, 2번 인덱스 : 몇 번째인지

    // 다음 이동경로가 존재하는지에 대한 함수. 존재한다면 queue에 이동된 경로의 값과 몇 번째 값인지 넣기
    fun verifyHaveNextRoute(first: Int, second: Int, third: Int) {
        if(board[first][second] == 1 && visit[first][second] == 0) {
            visit[first][second] = 1
            q.add(intArrayOf(first, second, third + 1))
        }
    }

    for(i in 1..n) {
        val line = readLine()!!
        for(j in 1..m) {
            board[i][j] = line[j-1].toString().toInt()
        }
    }

    visit[1][1] = 1
    q.add(intArrayOf(1, 1, 1))

    while(!q.isEmpty()) {
        val now = q.remove()

        if(now[0] == n && now[1] == m) {
            println(now[2])
            break
        }

        verifyHaveNextRoute(now[0]-1, now[1], now[2])
        verifyHaveNextRoute(now[0]+1, now[1], now[2])
        verifyHaveNextRoute(now[0], now[1]-1, now[2])
        verifyHaveNextRoute(now[0], now[1]+1, now[2])
    }
}