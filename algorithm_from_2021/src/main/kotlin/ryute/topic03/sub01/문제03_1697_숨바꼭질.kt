package ryute.topic03.sub01

import java.util.*

private val isVisited = Array(100001) { false }
private var ans = -1

private fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    bfs(n, k)
    println(ans)
}

private fun bfs(start: Int, end: Int) {
    var isCaught = false

    val q = LinkedList<Int>()
    q.add(start)
    isVisited[start] = true

    while(!isCaught) {
        val queueSize = q.size

        repeat(queueSize) {
            val target = q.poll()

            if(target == end) {
                isCaught = true
                return@repeat
            }

            val walkPrevious = target - 1
            val walkNext = target + 1
            val teleport = target * 2

            if(walkPrevious >= 0 && !isVisited[walkPrevious]) {
                q.add(walkPrevious)
                isVisited[walkPrevious] = true
            }

            if(walkNext <= 100000 && !isVisited[walkNext]) {
                q.add(walkNext)
                isVisited[walkNext] = true
            }

            if(teleport <= 100000 && !isVisited[teleport]) {
                q.add(teleport)
                isVisited[teleport] = true
            }
        }
        ans++
    }

}