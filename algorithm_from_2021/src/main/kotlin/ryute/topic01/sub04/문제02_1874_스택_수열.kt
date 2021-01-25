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
    val sb = StringBuilder()

    val n = readLine()!!.toInt()
    val s = Stack<Int>()

    var lastStacked = 0

    for(i in 1..n) {
        val target = readLine()!!.toInt()
        if (target > lastStacked) {
            for (item in (lastStacked + 1)..target) {
                s.push(item)
                sb.append("+\n")
            }
            lastStacked = target

            s.pop()
            sb.append("-\n")
        } else {
            if(s.pop() == target) {
                sb.append("-\n")
            } else {
                sb.clear()
                sb.append("NO")
                break
            }
        }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}