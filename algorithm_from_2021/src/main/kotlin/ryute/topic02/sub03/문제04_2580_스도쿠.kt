package ryute.topic02.sub03

import kotlin.system.exitProcess

private lateinit var arr: Array<IntArray>
private lateinit var blankPos: MutableList<Pair<Int, Int>>

private fun main() {
    arr = Array(9) {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }
    blankPos = mutableListOf<Pair<Int, Int>>()
    for(i in 0 until 9) {
        for(j in 0 until 9) {
            if(arr[i][j] == 0) {
                blankPos.add(Pair(i, j))
            }
        }
    }
    backTracking(0)
}

private fun backTracking(level: Int) {
    if (level == blankPos.size) {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${arr[i][j]} ")
            }
            println()
        }
        exitProcess(0)
    }

    val position = blankPos[level]
    val (row, col) = position.first to position.second

    for (num in 1..10) {
        if (num == 10) {
            arr[row][col] = 0
            return
        }

        arr[row][col] = num
        if (isPossible(level)) {
            backTracking(level + 1)
        }
    }
}

private fun isPossible(level: Int): Boolean {
    val position = blankPos[level]
    val (row, col) = position.first to position.second
    val value = arr[row][col]

    // 가로
    for(i in 0 until 9) {
        if(i != col && value == arr[row][i]) {
            return false
        }
    }

    // 세로
    for(i in 0 until 9) {
        if(i != row && value == arr[i][col]) {
            return false
        }
    }

    // 박스 (0, 1, 2)
    val rowBox = row / 3
    val colBox = col / 3

    for(i in 3 * rowBox until 3 * (rowBox + 1)) {
        for(j in 3 * colBox until 3 * (colBox + 1)) {
            if(i != row && j != col && value == arr[i][j]) {
                return false
            }
        }
    }

    return true
}