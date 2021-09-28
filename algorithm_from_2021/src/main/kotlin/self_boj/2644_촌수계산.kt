package self_boj

import java.util.*

private fun main() {
    var ans = -1

    val n = readLine()!!.toInt()
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()
    val arr = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1) { false }
    visited[0] = true

    repeat(m) {
        val cur = readLine()!!.split(" ").map { it.toInt() }
        arr[cur[0]].add(cur[1])
        arr[cur[1]].add(cur[0])
    }

    val q = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(a, 0))
    visited[a] = true

    while(q.isNotEmpty()) {
        val now = q.poll()
        if(now.first == b) {
            ans = now.second
            break
        }
        arr[now.first].forEach {
            if(!visited[it]) {
                q.offer(Pair(it, now.second + 1))
                visited[it] = true
            }
        }
    }

    print(ans)
}