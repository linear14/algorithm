package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200329
// 1427 - 소트인사이드

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine()
    val list: List<Int> = List(n.length) { i ->
        n[i].toString().toInt()
    }

    var count = Array(10) { 0 }
    for(i in list) {
        count[i]++
    }

    for(i in 9 downTo 0) {
        for(j in 1..count[i]) {
            bw.write("$i")
        }
    }
    bw.flush()
}
