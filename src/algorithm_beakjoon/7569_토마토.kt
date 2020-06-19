package src.algorithm_beakjoon

import java.util.*

// 200619
// 7569 - 토마토

fun main() {
    val (m, n, h) = readLine()!!.split(" ").map{ it.toInt() }
    val boxes = Array(h+2){ Array(n+2){ Array(m+2){ -1 } } }
    val visit = Array(h+2){ Array(n+2){ Array(m+2){ 0 } } }
    val q = LinkedList<Array<Int>>()
    var ans = 0
    var flag = false    // 토마토가 추가적으로 익는지 아닌지.. true값이 걸리면 토마토가 영향을 받아 익게 되므로 ans+1

    for(i in 1..h) {
        for(j in 1..n) {
            val tomatoes = readLine()!!.split(" ").map{ it.toInt() }
            for(k in 1..m) {
                boxes[i][j][k] = tomatoes[k-1]
                if(tomatoes[k-1] == 1) {
                    q.add(arrayOf(i, j, k))
                    visit[i][j][k] = 1
                }
            }
        }
    }

    // 토마토가 익었던 토마토에 영향을 받아 익으면 -> 방문처리 해주고, 토마토의 상태를 1로 바꿔준다. 또한 flag를 true로 바꿔줌
    fun verifyTomatoRipen(f: Int, s: Int, t: Int) {
        if(boxes[f][s][t] == 0 && visit[f][s][t] == 0) {
            q.add(arrayOf(f, s, t))
            visit[f][s][t] = 1
            boxes[f][s][t] = 1
            flag = true
        }
    }

    while(!q.isEmpty()) {
        var size = q.size
        if(flag) ans++
        flag = false    // flag 초기화 (큐에 들어있어도 전염되는 토마토가 없다면 ans를 늘려주면 안되므로)

        while(size-- > 0) {
            val now = q.remove()
            verifyTomatoRipen(now[0]-1, now[1], now[2])
            verifyTomatoRipen(now[0]+1, now[1], now[2])
            verifyTomatoRipen(now[0], now[1]-1, now[2])
            verifyTomatoRipen(now[0], now[1]+1, now[2])
            verifyTomatoRipen(now[0], now[1], now[2]-1)
            verifyTomatoRipen(now[0], now[1], now[2]+1)
        }
    }

    // 전체 과정에서 익지 않은 토마토가 있을수도 있으니 검사해주는 과정
    var isAllRipen = true
    loop@for(i in 1..h) {
        for(j in 1..n) {
            for(k in 1..m) {
                if(boxes[i][j][k] == 0) {
                    print(-1)
                    isAllRipen = false
                    break@loop
                }
            }
        }
    }
    if(isAllRipen) print(ans)
}