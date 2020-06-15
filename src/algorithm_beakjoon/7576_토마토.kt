package src.algorithm_beakjoon

import java.util.*

// 200614
// 7576 - 토마토

fun main() {
    val (m, n) = readLine()!!.split(" ").map{ it.toInt() }
    val box = Array(n+2){ Array(m+2) { -1 } }
    val visit = Array(n+2){ Array(m+2) { 0 } }
    val q = LinkedList<Pair<Int, Int>>()
    var ans = -1
    var flag = false    // 0이 남아 있는지 아닌지를 판단하는 flag

    fun checkTomato(first: Int, second: Int) {
        if(box[first][second] == 0 && visit[first][second] == 0) {
            box[first][second] = 1
            visit[first][second] = 1
            q.add(Pair(first, second))
        }
    }

    for(i in 1..n) {
        val line = readLine()!!.split(" ").map{ it.toInt() }
        for(j in 1..m) {
            box[i][j] = line[j-1]
            if(line[j-1] == 1) {
                q.add(Pair(i, j))
                visit[i][j] = 1
            }
        }
    }

    while(!q.isEmpty()) {
        var count = q.size
        while (count-- > 0) {
            val tomato = q.remove()

            checkTomato(tomato.first - 1, tomato.second)
            checkTomato(tomato.first + 1, tomato.second)
            checkTomato(tomato.first, tomato.second - 1)
            checkTomato(tomato.first, tomato.second + 1)
        }
        ans++
    }

    label@for(i in 1..n) for(j in 1..m) {
        if(box[i][j] == 0) {
            flag = true
            print(-1)
            break@label
        }
    }
    if(!flag) print(ans)
}
