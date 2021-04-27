package ryute.topic03.sub03

import java.util.*

private var m = 0
private var n = 0
private var k = 0
private lateinit var table: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)
private val q = LinkedList<Pair<Int, Int>>()

private var ans = 0
private val squareList = mutableListOf<Int>()

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    k = input[2]

    table = Array(m) { IntArray(n) }
    isVisited = Array(m) { BooleanArray(n) }
    repeat(k) {
        val pointInput = readLine()!!.split(" ").map { it.toInt() }
        val start = Pair(pointInput[0], pointInput[1])
        val end = Pair(pointInput[2], pointInput[3])

        for(i in start.first until end.first) {
            for(j in start.second until end.second) {
                table[j][i] = 1
            }
        }
    }

    for(i in 0 until m) {
        for(j in 0 until n) {
            if(table[i][j] == 0 && !isVisited[i][j]) {
                bfs(i,j)
            }
        }
    }
    println(ans)
    println(squareList.sorted().joinToString(" "))
}

private fun bfs(row: Int, col: Int) {
    var square = 0
    ans++

    q.add(Pair(row, col))
    isVisited[row][col] = true

    while(q.isNotEmpty()) {
        square++

        val current = q.poll()
        val currentRow = current.first
        val currentCol = current.second

        for(i in 0..3) {
            go(currentRow + dy[i], currentCol + dx[i])
        }
    }
    squareList.add(square)
}

private fun go(row: Int, col: Int) {
    if(row in 0 until m && col in 0 until n) {
        if(!isVisited[row][col] && table[row][col] == 0) {
            isVisited[row][col] = true
            q.add(Pair(row, col))
        }
    }
}