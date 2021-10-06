package self_boj

import java.util.*

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val ans = IntArray(input[0] + 1)
    val visited = BooleanArray(input[0] + 1)
    val q = LinkedList<Pair<Int, Int>>()
    visited[input[1]] = true
    q.offer(Pair(input[1], 0))

    while(q.isNotEmpty()){
        val cur = q.poll()
        val nextFloors = arrayOf(cur.first + input[3], cur.first - input[4])
        nextFloors.forEach { floor ->
            if(floor in 1..input[0] && !visited[floor]) {
                visited[floor] = true
                ans[floor] = cur.second + 1
                q.offer(Pair(floor, cur.second + 1))
            }
        }
    }

    if(visited[input[2]]) {
        print(ans[input[2]])
    } else {
        print("use the stairs")
    }
}