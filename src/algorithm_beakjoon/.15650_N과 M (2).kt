package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200427 ~ 200511
// 15650 - N과 M (2)

fun main() {
    // 속도 빠르게 한 번 해볼까? (15649번 문제와 속도 차이가 얼마나 나는지 궁금해서)
    // 결과 --> 헐.. 9배 정도나 더 빠르다.
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val builder = StringBuilder()

    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val answer = Array(m){ 0 }

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(answer[i] >= answer[level]) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == m) {
            for(i in answer) builder.append("$i ")
            builder.append("\n")
        } else {
            for(i in 1..n) {
                answer[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    bw.write(builder.toString())
    bw.flush()
}