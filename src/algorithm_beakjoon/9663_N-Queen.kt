package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.abs

// 200512
// 9663 - N-Queen

fun main() {
    val n = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val answer = Array(n){ 0 }
    var count = 0

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(answer[i] == answer[level] || abs(answer[level] - answer[i]) == level - i) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == n) count += 1
        else {
            for(i in 0 until n) {
                answer[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    bw.write(count.toString())
    bw.flush()
}