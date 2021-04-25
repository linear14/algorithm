package ryute.topic03.sub03

import java.util.*

private lateinit var table: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var q: LinkedList<Pair<Int, Int>>
private var ans = 0

private fun main() {
    val (col, row) = readLine()!!.split(" ").map { it.toInt() }
    table = Array(row + 2) { IntArray(col + 2) { -1 } }
    isVisited = Array(row + 2) { BooleanArray(col + 2) }
    q = LinkedList<Pair<Int, Int>>()

    for(i in 1..row) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        for(j in 1..col) {
            table[i][j] = line[j-1]
            if(line[j-1] == 1) {
                q.add(Pair(i, j))
            }
        }
    }

    bfs()

    if(isRipenAll(row, col)) {
        println(ans)
    } else {
        println(-1)
    }
}

private fun bfs() {
    while(q.isNotEmpty()) {
        val size = q.size
        for(i in 0 until size) {
            val (currentRow, currentCol) = q.poll().also { it.first to it.second }

            goNextIfPossible(currentRow - 1, currentCol)
            goNextIfPossible(currentRow + 1, currentCol)
            goNextIfPossible(currentRow, currentCol - 1)
            goNextIfPossible(currentRow, currentCol + 1)
        }
        if(q.isNotEmpty()) ans++
    }
}

private fun goNextIfPossible(newRow: Int, newCol: Int) {
    if(!isVisited[newRow][newCol] && table[newRow][newCol] == 0) {
        table[newRow][newCol] = 1
        q.add(Pair(newRow, newCol))
        isVisited[newRow][newCol] = true
    }
}

private fun isRipenAll(row: Int, col: Int): Boolean {
    for(i in 1..row) {
        for(j in 1..col) {
            if(table[i][j] == 0) return false
        }
    }
    return true
}