package ryute.topic03.sub01

import java.util.*

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<Boolean>
private var n: Int = -1
private var m: Int = -1
private var v: Int = -1

private fun main() {

    val inputs = readLine()!!.split(" ").map { it.toInt() }
    n = inputs[0]
    m = inputs[1]
    v = inputs[2]
    graph = Array(n + 1) { IntArray(n + 1) { 0 } }

    repeat(m) {
        val(i, j) = readLine()!!.split(" ").map { it.toInt() }
        graph[i][j]++
        graph[j][i]++
    }

    visited = Array(n + 1) { false }
    dfs()
    visited = Array(n + 1) { false }
    println()
    bfs()

}

private fun dfs() {
    val result = mutableListOf<Int>()

    val s = Stack<Int>()
    s.push(v)

    while(s.isNotEmpty()) {
        val target = s.pop()
        if(!visited[target]) {
            result.add(target)
        }
        visited[target] = true

        for(i in n downTo 1) {
            if(graph[target][i] != 0 && !visited[i]) {
                s.push(i)
            }
        }
    }

    for(i in result) {
        print("$i ")
    }
}

private fun bfs() {
    val result = mutableListOf<Int>()

    val q = LinkedList<Int>()
    q.add(v)

    while(q.isNotEmpty()) {
        val target = q.poll()
        if(!visited[target]) {
            result.add(target)
        }
        visited[target] = true

        for(i in 1 .. n) {
            if(graph[target][i] != 0 && !visited[i]) {
                q.add(i)
            }
        }
    }

    for(i in result) {
        print("$i ")
    }
}

