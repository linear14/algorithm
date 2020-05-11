package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder

// 200511
// 15651 - N과 M (3)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val builder = StringBuilder()

    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val answer = Array(m){ 0 }

    fun backTracking(level: Int) {
        if(level == m) {
            for(i in answer) builder.append("$i ")
            builder.append("\n")
        } else {
            for(i in 1..n) {
                answer[level] = i
                backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    bw.write(builder.toString())
    bw.flush()

}
