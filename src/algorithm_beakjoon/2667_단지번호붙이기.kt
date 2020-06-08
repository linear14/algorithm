package src.algorithm_beakjoon

import java.util.*

fun main() {
    // 단지 둘레에 0으로 둘러싼 칸을 하나 더 만들자
    val n = readLine()!!.toInt()
    val array = Array(n + 2){ Array(n + 2){ 0 } }
    val visit = Array(n + 2){ Array(n + 2){ 0 } }
    val ans = mutableListOf<Int>()


    for(i in 1..n) {
        val line = readLine()!!
        for(j in 1..n) {
            array[i][j] = line[j - 1].toString().toInt()
        }
    }


    for(i in 1..n) {
        for(j in 1..n) {
            var count = 0
            if(array[i][j] == 0) visit[i][j] = 1

            if(array[i][j] == 1 && visit[i][j] == 0) {
                visit[i][j] = 1
                val q = LinkedList<Pair<Int, Int>>()
                q.add(Pair(i, j))

                while(!q.isEmpty()) {
                    val s = q.remove()
                    count++

                    if(array[s.first-1][s.second] == 1 && visit[s.first-1][s.second] == 0) {
                        q.add(Pair(s.first-1, s.second))
                        visit[s.first-1][s.second] = 1
                    }

                    if(array[s.first][s.second-1] == 1 && visit[s.first][s.second-1] == 0) {
                        q.add(Pair(s.first, s.second-1))
                        visit[s.first][s.second-1] = 1
                    }

                    if(array[s.first+1][s.second] == 1 && visit[s.first+1][s.second] == 0) {
                        q.add(Pair(s.first+1, s.second))
                        visit[s.first+1][s.second] = 1
                    }

                    if(array[s.first][s.second+1] == 1 && visit[s.first][s.second+1] == 0) {
                        q.add(Pair(s.first, s.second+1))
                        visit[s.first][s.second+1] = 1
                    }
                }
            }

            if(count != 0) ans.add(count)
        }
    }

    ans.sort()
    println(ans.size)
    for(i in ans) println(i)
}