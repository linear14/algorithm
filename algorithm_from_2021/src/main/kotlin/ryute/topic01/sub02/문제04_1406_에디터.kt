package ryute.topic01.sub02

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    solution02()
}

// 시간 초과
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = readLine()!!
    val typed = LinkedList<String>().apply {
        line.forEach {
            add(it.toString())
        }
    }
    var cursor = typed.size

    repeat(readLine()!!.toInt()) {
        val command = readLine()!!.split(" ")

        when(command[0]) {
            "L" -> {
                if(cursor > 0) cursor--
            }
            "D" -> {
                if(cursor < typed.size) cursor++
            }
            "B" -> {
                if(cursor != 0) {
                    typed.removeAt(--cursor)
                }
            }
            "P" -> {
                typed.add(cursor, command[1])
                cursor++
            }
        }
    }

    typed.forEach { bw.write(it) }
    bw.flush()
    bw.close()
}


/*
    solution01 에서의 문제점은
    리스트에서 cursor의 위치의 바로 옆에 element를 삭제/추가 하는 과정에서 탐색에 걸리는 시간을 고려하지 않았다는 것이다.
    (탐색에 걸리는 시간이 O(N)이 아니기 때문)

    이는 아래 해결책처럼 두 개의 Deque를 사용하여 해결 가능한데,
    Deque의 맨 앞/맨 뒤 에서만 element의 삭제/추가가 이루어지므로 시간복잡도를 크게 줄일 수 있게된다.
 */
/*** 정답 코드 ***/
private fun solution02() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val beforeCursor = LinkedList<String>().apply {
        readLine()!!.map {
            add(it.toString())
        }
    }
    val afterCursor = LinkedList<String>()

    repeat(readLine()!!.toInt()) {
        val cmd = readLine()!!.split(" ")

        when(cmd[0]) {
            "L" -> {
                if(beforeCursor.isNotEmpty()) {
                    afterCursor.push(beforeCursor.pollLast())
                }
            }
            "D" -> {
                if(afterCursor.isNotEmpty()) {
                    beforeCursor.add(afterCursor.pollFirst())
                }
            }
            "B" -> {
                if(beforeCursor.isNotEmpty()) {
                    beforeCursor.pollLast()
                }
            }
            "P" -> {
                beforeCursor.add(cmd[1])
            }
        }
    }

    beforeCursor.forEach { bw.write(it) }
    afterCursor.forEach { bw.write(it) }

    bw.flush()
    bw.close()
}