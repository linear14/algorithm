package ryute.topic03.sub03

import java.util.*

private var n = 0
private var m = 0
private lateinit var map: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var s: Stack<Pair<Int, Int>>
private var ans = Integer.MAX_VALUE

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    map = Array(n + 2) { IntArray( m + 2) { 2 } }
    for(i in 1 .. n) {
        val line = readLine()!!
        for(j in 1 .. m) {
            map[i][j] = line[j-1].toString().toInt()
        }
    }
    isVisited = Array(n + 2) { BooleanArray(m + 2) }

    s = Stack<Pair<Int, Int>>()
    s.push(Pair(1, 1))
    isVisited[1][1] = true

    dfs(1, 1, 1, false)

    println(if(ans == Integer.MAX_VALUE) -1 else ans)
}

private fun dfs(row: Int, col: Int, level: Int, isBroken: Boolean) {
    if(level > ans) {
        return
    }
    if(row == n && col == m) {
        if(ans >= level) {
            ans = level
        }
        return
    }

    goNextIfPossible(row - 1, col, level, isBroken)
    goNextIfPossible(row + 1, col, level, isBroken)
    goNextIfPossible(row, col - 1, level, isBroken)
    goNextIfPossible(row, col + 1, level, isBroken)
}

private fun goNextIfPossible(newRow: Int, newCol: Int, level: Int, isBroken: Boolean) {

    if(!isVisited[newRow][newCol]) {
        // 이동가능
        if(map[newRow][newCol] == 0) {
            isVisited[newRow][newCol] = true
            dfs(newRow, newCol, level + 1, isBroken)
            isVisited[newRow][newCol] = false
        }

        // 막혀있는 상태. (isBroken이 true면 이동불가, false면 이동)
        if(!isBroken && map[newRow][newCol] == 1) {
            isVisited[newRow][newCol] = true
            dfs(newRow, newCol, level + 1, true)
            isVisited[newRow][newCol] = false
        }
    }
}
