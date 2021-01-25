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
    repeat(t) loop@ {
        val s = Stack<Int>()
        val cmd = readLine()!!.toString()
        cmd.forEach {
            if(it == '(') {
                s.push(1)
            } else {
                if(s.isEmpty()) {
                    bw.write("NO\n")
                    return@loop
                } else {
                    s.pop()
                }
            }
        }
        if(s.isEmpty()) {
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }

    }

    bw.flush()
    bw.close()
}