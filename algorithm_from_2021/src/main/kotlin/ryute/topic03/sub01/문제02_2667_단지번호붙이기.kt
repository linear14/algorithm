package ryute.topic03.sub01

import java.util.*

private var n: Int = 0
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<Array<Boolean>>
private var cnt = 0
private val connectCntList = mutableListOf<Int>()

private fun main() {
    n = readLine()!!.toInt()
    map = Array(n) { IntArray(n) { 0 } }
    visited = Array(n) { Array(n) { false } }

    for(i in 0 until n) {
        val line = readLine()!!
        for(j in 0 until n) {
            if(line[j] == '1') {
                map[i][j] = 1
            }
        }
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            dfs(i, j)
        }
    }

    connectCntList.sort()
    println(cnt)
    for(i in connectCntList) {
        println(i)
    }
}

private fun dfs(i: Int, j: Int) {
    if(visited[i][j]) {
        return
    }

    if(map[i][j] == 0) {
        visited[i][j] = true
        return
    }

    var connectCnt = 0

    val stack = Stack<Pair<Int, Int>>()
    stack.add(Pair(i, j))
    visited[i][j] = true

    while(stack.isNotEmpty()) {
        connectCnt++
        val target = stack.pop()
        val (a, b) = target.first to target.second

        if(a < n - 1 && map[a + 1][b] == 1 && !visited[a + 1][b]) {
            stack.add(Pair(a + 1, b))
            visited[a + 1][b] = true
        }

        if(b < n - 1 && map[a][b + 1] == 1 && !visited[a][b + 1]) {
            stack.add(Pair(a, b + 1))
            visited[a][b + 1] = true
        }

        if(a > 0 && map[a - 1][b] == 1 && !visited[a - 1][b]) {
            stack.add(Pair(a - 1, b))
            visited[a - 1][b] = true
        }

        if(b > 0 && map[a][b - 1] == 1 && !visited[a][b - 1]) {
            stack.add(Pair(a, b - 1))
            visited[a][b - 1] = true
        }

    }

    cnt++
    connectCntList.add(connectCnt)
}