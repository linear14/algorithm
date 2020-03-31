package algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200331
// 4673 - 셀프 넘버

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val notAnswer = mutableListOf<Int>()
    for(i in 1 until 9999) {
        var notAnswerNum = i
        val iToString = i.toString()
        for(j in iToString) {
            notAnswerNum += j.toString().toInt()
        }
        notAnswer.add(notAnswerNum)
    }
    notAnswer.sort()

    for(i in 1..10000) {
        if(i in notAnswer) {
            continue
        }
        bw.write("$i\n")
    }
    bw.flush()
}
