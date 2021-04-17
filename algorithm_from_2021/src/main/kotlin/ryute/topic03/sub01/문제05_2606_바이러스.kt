package ryute.topic03.sub01

import java.util.*

private var n = -1
private lateinit var table: Array<IntArray>
private lateinit var isVisited: BooleanArray

private var ans = -1

private fun main() {
    n = readLine()!!.toInt()
    val line = readLine()!!.toInt()

    table = Array(n + 1) { IntArray(n + 1) { 0 } }
    isVisited = BooleanArray(n + 1) { false }

    repeat(line) {
        val (i, j) = readLine()!!.split(" ").map { it.toInt() }
        table[i][j] = 1
        table[j][i] = 1
    }

    dfs()
    println(ans)
}

private fun dfs() {

    val s = Stack<Int>()
    s.push(1)
    isVisited[1] = true

    while(s.isNotEmpty()) {
        ans++
        val target = s.pop()

        for(i in 1..n) {
            if(table[target][i] == 1 && !isVisited[i]) {
                s.push(i)
                isVisited[i] = true
            }
        }
    }
}

