package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200403
// 2581 - 소수

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (m, n) = br.readLine().toInt() to br.readLine().toInt()
    val answerList = mutableListOf<Int>()

    val numberList = MutableList(10000) { i -> i + 1 }
    numberList.remove(1)

    var index = 0
    while(index < numberList.size) {
        var num = numberList[index]
        while(num < 10000) {
            num += numberList[index]
            numberList.remove(num)
        }
        index++
    }

    for(i in m..n) {
        if(i in numberList) {
            answerList.add(i)
        }
    }
    if(answerList.size == 0) {
        bw.write("-1")
    } else {
        bw.write("${answerList.sum()}\n${answerList[0]}")
    }
    bw.flush()
}