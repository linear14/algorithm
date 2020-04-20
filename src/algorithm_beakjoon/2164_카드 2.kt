package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200420
// 2164 - 카드 2

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = LinkedList<Int>()

    for(i in 1..n) list.add(i)

    while(list.size > 1) {
        list.poll()
        val out = list.poll()
        list.add(out)
    }

    bw.write(list.poll().toString())
    bw.flush()
}