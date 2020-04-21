package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200421
// 2309 - 일곱 난쟁이

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val answerList = mutableListOf<Int>()

    val heights = MutableList(9){ br.readLine().toInt() }
    a@for(i in 0 until heights.size) {
        for(j in i + 1 until heights.size) {
            var sum = 0
            answerList.clear()
            for((index, height) in heights.withIndex()) {
                if(index == i || index == j) continue
                sum += height
                answerList.add(height)
            }
            if(sum == 100) break@a
        }
    }

    answerList.sort()
    for(i in answerList) bw.write("$i\n")
    bw.flush()
}