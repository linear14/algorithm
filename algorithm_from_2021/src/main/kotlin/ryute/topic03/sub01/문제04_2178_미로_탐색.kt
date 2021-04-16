package ryute.topic03.sub01

import java.util.*

private lateinit var table: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var ans = 0

private fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    table = Array(n) {
        val intArray = IntArray(m)
        val line = readLine()!!
        for(i in line.indices) {
            intArray[i] = line[i].toString().toInt()
        }
        intArray
    }
    isVisited = Array(n) { BooleanArray(m) { false } }

    bfs(n, m)
    println(ans)
}

private fun bfs(maxRow: Int, maxCol: Int) {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(0, 0))
    isVisited[0][0] = true

    loop@while(true) {
        val queueSize = q.size
        ans++

        for(i in 0 until queueSize) {
            val target = q.poll()

            val row = target.first
            val col = target.second

            if(row == maxRow - 1 && col == maxCol - 1) {
                break@loop
            }

            if(row > 0 && table[row - 1][col] == 1 && !isVisited[row - 1][col]) {
                q.add(Pair(row - 1, col))
                isVisited[row - 1][col] = true
            }

            if(row < maxRow - 1 && table[row + 1][col] == 1 && !isVisited[row + 1][col]) {
                q.add(Pair(row + 1, col))
                isVisited[row + 1][col] = true
            }

            if(col > 0 && table[row][col - 1] == 1 && !isVisited[row][col - 1]) {
                q.add(Pair(row, col - 1))
                isVisited[row][col - 1] = true
            }

            if(col < maxCol - 1 && table[row][col + 1] == 1 && !isVisited[row][col + 1]) {
                q.add(Pair(row, col + 1))
                isVisited[row][col + 1] = true
            }
        }
    }
}