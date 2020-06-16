package src.algorithm_beakjoon

import java.util.*

// 200616
// 14502 - 연구소

/*

        backTracking + BFS 모두 사용해서 풀어봤음
        정신없다 ㅋㅋㅋ

        backTracking으로는, 좌표값을 순차적으로 넣을 수 있는 경우에 true
        그에더해, 현재 level의 값이 board에서 0일 경우에만 true 부여했음 (왜냐하면 벽을 생성하는 backTracking 중이라서)

        그리고 그 backTracking이 끝까지 도달했을 경우 bfs를 실행하는 것으로 설정했다!
        여기서 감염자수 체크했고, 감염자수가 최소인 경우를 계속 min으로 갈아줬음

        BFS는 평소 하던것처럼 2를 포인트 시작으로, 주변에 0이 있는 경우만 계속 탐색 하도록 추가해줬다.

 */

fun main() {
    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val board = Array(n + 2){ Array(m + 2) { 1 } }
    val virus = mutableListOf<Pair<Int, Int>>()
    var wall = 3
    val q = LinkedList<Pair<Int, Int>>()
    var visit = Array(n + 2){ Array(m + 2) { 0 } }

    for(i in 1..n) {
        val line = readLine()!!.split(" ").map{ it.toInt() }
        for(j in 1..m) {
            if(line[j-1] == 1) wall++
            if(line[j-1] == 2) virus.add(Pair(i, j))
            board[i][j] = line[j-1]
        }
    }

    var infection = 0
    var min = Integer.MAX_VALUE
    val position = Array(3){ Pair(-1, -1) }

    fun verifyPassVirus(first: Int, second: Int) {
        if(board[first][second] == 0 && visit[first][second] == 0) {
            visit[first][second] = 1
            q.add(Pair(first, second))
        }
    }

    fun isPossible(level: Int): Boolean {
        if(board[position[level].first][position[level].second] in 1..2) return false
        for(i in 0 until level) {
            if(position[level].first < position[i].first) return false
            if(position[level].first == position[i].first && position[level].second <= position[i].second) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == 3) {
            q.clear()
            visit = Array(n + 2){ Array(m + 2) { 0 } }
            infection = 0

            for(i in position) board[i.first][i.second] = 1
            for(i in virus) {
                q.add(i)
                visit[i.first][i.second] = 1
            }

            while(!q.isEmpty()) {
                val f = q.remove()
                infection++
                verifyPassVirus(f.first-1, f.second)
                verifyPassVirus(f.first+1, f.second)
                verifyPassVirus(f.first, f.second-1)
                verifyPassVirus(f.first, f.second+1)
            }

            for(i in position) board[i.first][i.second] = 0
            if(min > infection) min = infection


        } else {
            for(i in 1..n) {
                for(j in 1..m) {
                    position[level] = Pair(i, j)
                    if(isPossible(level)) backTracking(level + 1)
                }
            }
        }
    }

    backTracking(0)
    println(n*m - wall - min)

}
