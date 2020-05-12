package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200512
// 15652 - N과 M (4)

fun main() {
    with(StringBuilder()) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val answer = Array(m){ 0 }

        fun isPossible(level: Int): Boolean {
            for(i in 0 until level) {
                if(answer[i] > answer[level]) return false
            }
            return true
        }

        fun backTracking(level: Int) {
            if(level == m) {
                for(i in answer) append("$i ")
                append("\n")
            } else {
                for(i in 1 .. n) {
                    answer[level] = i
                    if(isPossible(level)) backTracking(level + 1)
                }
            }
        }

        backTracking(0)
        bw.write(toString())
        bw.flush()
    }
}