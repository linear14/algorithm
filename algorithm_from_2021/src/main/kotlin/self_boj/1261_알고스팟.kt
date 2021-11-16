package self_boj

import java.util.*

private data class Position(val r: Int, val c: Int, val min: Int)

private fun main() {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val input = Array(n){ readLine()!!.split("").subList(1, m + 1).map { it.toInt() } }
    val visited = Array(n) { BooleanArray(m) { false } }
    val ans = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    ans[0][0] = 0
    visited[0][0] = true

    val pq = PriorityQueue<Position> { a, b -> a.min - b.min }
    pq.add(Position(0, 0, 0))

    while(pq.isNotEmpty()) {
        val cur = pq.poll()
        visited[cur.r][cur.c] = true

        // 생각해봤는데, 만약 내가 체크할 다음 지점을 이미 방문했을 경우라면 해당 영역은 또 다시 체크 안해도 된다.
        // 왜냐하면, 다음 지점을 방문했다는 소리는 현재 지점보다 결과값이 무조건 작을 수 밖에 없다는 뜻이기 때문이다.

        for(i in 0 until 4) {
            val nr = cur.r + dy[i]
            val nc = cur.c + dx[i]

            if(nr in 0 until n && nc in 0 until m) {
                val go = ans[cur.r][cur.c] + input[nr][nc]

                if(ans[nr][nc] > go) {
                    ans[nr][nc] = go
                    if(!visited[nr][nc]) {
                        pq.add(Position(nr, nc, go))
                    }
                }
            }
        }
    }
    print(ans[n-1][m-1])
}