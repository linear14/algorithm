package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200326
// 15552 - 빠른 A+B

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var t = br.readLine().toInt()
    while(t-- > 0) {
        val input = br.readLine().split(" ")
        bw.write("${input[0].toInt() + input[1].toInt()}\n")
    }
    bw.flush()
    bw.close()
}