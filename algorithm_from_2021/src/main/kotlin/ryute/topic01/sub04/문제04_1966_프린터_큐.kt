package ryute.topic01.sub04

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()

    repeat(t) {
        val (n, targetPosition) = readLine()!!.split(" ").map { it.toInt() }.let {
            it[0] to it[1]
        }

        // 우선순위를 리스트로, 정렬한 값을 또 리스트로 ( 마지막 인덱스 값이 우선순위가 가장 높게 됨 )
        val priority = readLine()!!.split(" ").map { it.toInt() }
        val sortedPriority = priority.sorted().toMutableList()

        val q = LinkedList<Pair<Int, Int>>() // 최초 인덱스, 우선순위

        for((index, p) in priority.withIndex()) {
            q.push(Pair(index, p))
        }

        var cnt = 1
        while(true) {
            val next = q.pollLast()
            val targetPriority = sortedPriority[sortedPriority.size - 1]

            if(next.second == targetPriority) {
                if(next.first == targetPosition) {
                    bw.write("$cnt\n")
                    break
                } else {
                    // 우선순위가 가장 높았다면 큐에서도 제거되지만 정렬된 리스트에서도 제거된다.
                    sortedPriority.removeLast()
                    cnt++
                }
            } else {
                // 우선순위가 아니였다면 다시 넣어줌
                q.push(next)
            }
        }
    }

    bw.flush()
    bw.close()
}