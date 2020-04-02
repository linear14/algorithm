package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200326
// 10952 - A+B - 5

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while(true) {
        val input = br.readLine().split(" ")
        if(input[0].toInt() == 0 && input[1].toInt() == 0) {
            break
        }
        bw.write("${input[0].toInt() + input[1].toInt()}\n")
    }
    bw.flush()
    bw.close()
}