package ryute.topic03.sub03

import java.util.*

private var row = 0
private var col = 0
private lateinit var table: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private val dx = arrayOf(-1, 0, 1, 0)
private val dy = arrayOf(0, -1, 0, 1)
private var q = LinkedList<Pair<Int, Int>>()
private var currentCheeseCount = 0
private var lastDeletedCheeses = 0
private var level = 0

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    row = input[0]
    col = input[1]

    table = Array(row) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(row) { BooleanArray(col) }

    for(i in 0 until row) {
        for(j in 0 until col) {
            if(table[i][j] == 1) {
                currentCheeseCount++
            }
        }
    }

    while(currentCheeseCount != 0) {
        findHole()
        findMeltingCheese()
    }
    println(level)
    println(lastDeletedCheeses)
}

private fun findHole() {
    isVisited = Array(row) { BooleanArray(col) }
    q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(0, 0))
    table[0][0] = 2
    isVisited[0][0] = true

    while(q.isNotEmpty()) {
        val current = q.poll()
        val currentRow = current.first
        val currentCol = current.second

        for(i in 0..3) {
            verifyIsHole(currentRow + dy[i], currentCol + dx[i])
        }
    }

}

private fun verifyIsHole(newRow: Int, newCol: Int) {
    if(newRow in 0 until row && newCol in 0 until col) {
        if(!isVisited[newRow][newCol] && table[newRow][newCol] != 1) {
            isVisited[newRow][newCol] = true
            table[newRow][newCol] = 2
            q.add(Pair(newRow, newCol))
        }
    }
}

private fun findMeltingCheese() {
    val list = mutableListOf<Pair<Int, Int>>()

/*    for(i in 0 until row) {
        for(j in 0 until col) {
            print("${table[i][j]} ")
        }
        println()
    }*/

    for(i in 0 until row) {
        for(j in 0 until col) {
            if(table[i][j] == 1 && isNearAir(i, j)) {
                list.add(Pair(i, j))
            }
        }
    }

    for(i in list) {
        table[i.first][i.second] = 2
    }

    lastDeletedCheeses = list.size
    currentCheeseCount -= list.size
    level++

    // println("level: $level, originalCheeses: ${currentCheeseCount + lastDeletedCheeses}, currentCheeseCount: ${currentCheeseCount}, lastDeleteCheeses: $lastDeletedCheeses")
}

private fun isNearAir(row: Int, col: Int): Boolean {
    for(i in 0..3) {
        if(table[row+dy[i]][col+dx[i]] == 2) {
            return true
        }
    }
    return false
}