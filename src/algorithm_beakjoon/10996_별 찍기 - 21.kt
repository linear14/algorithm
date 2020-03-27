package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200327
// 10996 - 별 찍기 - 21

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    if(n == 1) {
        bw.write("*")
    } else {
        for (i in 1..n) {
            for (j in 1..n) {
                if(j % 2 == 0) {
                    bw.write(" ")
                } else {
                    bw.write("*")
                }
            }
            bw.write("\n")
            for (j in 1..n) {
                if(j % 2 == 0) {
                    bw.write("*")
                } else {
                    bw.write(" ")
                }
            }
            if(i != n) {
                bw.write("\n")
            }
        }
    }
    bw.flush()
    bw.close()
}