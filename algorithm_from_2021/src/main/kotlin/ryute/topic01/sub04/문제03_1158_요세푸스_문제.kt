package ryute.topic01.sub04

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder().apply { append("<") }

    val (n, k) = readLine()!!.split(" ").map{ it.toInt() }.let {
        it[0] to it[1]
    }

    val circle = LinkedList<Int>().apply {
        for(i in 1 .. n) {
            push(i)
        }
    }

    for(i in 0 until n) {
        for(trial in 1 until k) {
           circle.push(circle.pollLast())
        }
        sb.append(circle.pollLast())

        if(i != n - 1) {
            sb.append(", ")
        } else {
            sb.append(">")
        }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}