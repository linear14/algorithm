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

    val n = br.readLine().toInt()
    for(i in 1 .. n) {
        for(j in 1 .. i) {
            bw.write("*")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}