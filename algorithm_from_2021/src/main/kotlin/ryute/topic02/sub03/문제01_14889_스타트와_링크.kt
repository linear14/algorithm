package ryute.topic02.sub03

import kotlin.math.abs

private var n: Int = 0
private var table: Array<IntArray> = arrayOf()
private var isVisited: Array<Boolean> = arrayOf()
private var min = Int.MAX_VALUE

private fun main() {
    n = readLine()!!.toInt()
    table = Array(n) { IntArray(n) }
    isVisited = Array(n) { false }

    for (i in 0 until n) {
        table[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    backTracking(0, 0)
    print(min)
}

private fun backTracking(start: Int, level: Int) {
    if(level == (n / 2)) {
        val startTeam = mutableListOf<Int>()
        val linkTeam = mutableListOf<Int>()
        var startScore = 0
        var linkScore = 0

        for(i in 0 until n) {
            if(isVisited[i]) {
                startTeam.add(i)
            } else {
                linkTeam.add(i)
            }
        }

        for(i in startTeam) {
            for(j in startTeam) {
                startScore += table[i][j]
            }
        }

        for(i in linkTeam) {
            for(j in linkTeam) {
                linkScore += table[i][j]
            }
        }

        val diff = abs(startScore - linkScore)
        if(diff < min) {
            min = diff
        }
        return
    }

    for(i in start until n) {
        isVisited[i] = true
        backTracking(i + 1, level + 1)
        isVisited[i] = false
    }
}

