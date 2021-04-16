package ryute.topic03.sub01

import java.util.*

private lateinit var table: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private val q = LinkedList<IntArray>()

private fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    table = Array(n + 2) { IntArray(m + 2) { 0 } }
    isVisited = Array(n + 2) { BooleanArray(m + 2) { false } }

    for(i in 1..n) {
        val line = readLine()!!
        for(j in 1..m) {
            table[i][j] = line[j-1].toString().toInt()
        }
    }

    bfs(n, m)
}

private fun bfs(n: Int, m: Int) {
    q.add(intArrayOf(1, 1, 1))
    isVisited[1][1] = true

    while(q.isNotEmpty()) {
        val now = q.poll()

        val row = now[0]
        val col = now[1]
        val currentCnt = now[2]

        if(row == n && col == m) {
            println(currentCnt)
            return
        }

        goNextIfPossible(row - 1, col, currentCnt)
        goNextIfPossible(row + 1, col, currentCnt)
        goNextIfPossible(row, col - 1, currentCnt)
        goNextIfPossible(row, col + 1, currentCnt)
    }
}

private fun goNextIfPossible(newRow: Int, newCol: Int, currentCnt: Int) {
    if(!isVisited[newRow][newCol] && table[newRow][newCol] == 1) {
        q.add(intArrayOf(newRow, newCol, currentCnt + 1))
        isVisited[newRow][newCol] = true
    }
}
