package ryute.topic01.sub03

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()!!.toInt()
    val list = Array<Pair<Int, Int>>(n) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        Pair(line[0], line[1])
    }.also {
        it.sortWith { dot1, dot2 ->
            if(dot1.second != dot2.second) {
                dot1.second - dot2.second
            } else {
                dot1.first - dot2.first
            }
        }
    }

    list.forEach {
        bw.write("${it.first} ${it.second}\n")
    }
    bw.flush()
    bw.close()
}