package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200326
// 10951 - A+B - 4

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while(true) {
        val inputLines = br.readLine() ?: break
        val input = inputLines.split(" ")
        bw.write("${input[0].toInt() + input[1].toInt()}\n")
    }
    bw.flush()
    bw.close()
}