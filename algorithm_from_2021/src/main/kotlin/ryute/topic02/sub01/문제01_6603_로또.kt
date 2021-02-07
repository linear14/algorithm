package ryute.topic02.sub01

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var result = Array(6) { 0 }
private var s = arrayOf<Int>()

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    while(true) {

        val st = StringTokenizer(readLine()!!, " ")
        val k = st.nextToken().toInt()

        if(k == 0) {
            break
        }

        s = Array(k) { st.nextToken().toInt() }
        result = Array(6) { 0 }
        solution01BackTracking(0)
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

private fun solution01BackTracking(level: Int) {
    if(level >= 6) {
        for(i in result) {
            bw.write("$i ")
        }
        bw.write("\n")
        return
    }

    for(num in s) {
        result[level] = num
        if(solution01IsPossible(level)) solution01BackTracking(level + 1)
    }
}

private fun solution01IsPossible(level: Int): Boolean {
    val targetItem = result[level]
    for(i in 0 until level) {
        if(targetItem <= result[i]) return false
    }
    return true
}