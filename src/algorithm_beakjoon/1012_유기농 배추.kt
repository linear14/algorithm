package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val builder = StringBuilder()

    val t = readLine()!!.toInt()
    repeat(t) {
        val case = readLine()!!.split(" ").map{ it.toInt() }
        val n = case[0]
        val m = case[1]
        val k = case[2]

        val land = Array(n + 2){ Array(m + 2) { 0 } }
        val visit = Array(n + 2){ Array(m + 2) { 0 } }
        var ans = 0
        var flag = false

        for(i in 0 until k) {
            val (x, y) = readLine()!!.split(" ").map{ it.toInt() + 1 }
            land[x][y] = 1
        }

        val q = LinkedList<Pair<Int, Int>>()
        for(i in 1..n) {
            for(j in 1..m) {
                if(land[i][j] == 0) {
                    visit[i][j] = 1
                }
                if(land[i][j] == 1 && visit[i][j] == 0) {
                    flag = true
                    q.add(Pair(i, j))
                    visit[i][j] = 1

                    while(!q.isEmpty()) {
                        val now = q.remove()

                        if(visit[now.first-1][now.second] == 0 && land[now.first-1][now.second] == 1) {
                            q.add(Pair(now.first-1, now.second))
                            visit[now.first-1][now.second] = 1
                        }
                        if(visit[now.first+1][now.second] == 0 && land[now.first+1][now.second] == 1) {
                            q.add(Pair(now.first+1, now.second))
                            visit[now.first+1][now.second] = 1
                        }
                        if(visit[now.first][now.second-1] == 0 && land[now.first][now.second-1] == 1) {
                            q.add(Pair(now.first, now.second-1))
                            visit[now.first][now.second-1] = 1
                        }
                        if(visit[now.first][now.second+1] == 0 && land[now.first][now.second+1] == 1) {
                            q.add(Pair(now.first, now.second+1))
                            visit[now.first][now.second+1] = 1
                        }
                    }
                }

                if(flag) {
                    ans++
                    flag = false
                }
            }

        }
        builder.append("$ans\n")
    }
    bw.write(builder.toString())
    bw.flush()
}