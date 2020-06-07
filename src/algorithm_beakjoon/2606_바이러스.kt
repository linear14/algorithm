package src.algorithm_beakjoon

import java.util.*

// 200608
// 2606 - 바이러스

fun main() {
    val n = readLine()!!.toInt()
    val e = readLine()!!.toInt()
    val adj = Array(n + 1){ mutableListOf<Int>() }
    val visit = Array(n + 1){ 0 }

    repeat(e) {
        val (from, to) = readLine()!!.split(" ").map{ it.toInt() }
        adj[from].add(to)
        adj[to].add(from)
    }

    // bfs
    val q = LinkedList<Int>()
    q.add(1)
    visit[1] = 1

    while(!q.isEmpty()) {
        val s = q.remove()
        for(i in adj[s]) {
            if(visit[i] == 0) {
                q.add(i)
                visit[i] = 1
            }
        }
    }

    var count = 0
    for(i in visit) {
        if(i == 1) count++
    }
    print(count - 1)
}