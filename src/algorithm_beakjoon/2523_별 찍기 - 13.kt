package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200327
// 2523 - 별 찍기 - 13

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    for(i in 1 until 2 * n) {
        if(i <= n) {
            for (j in 0 until i) {
                bw.write("*")
            }
        } else {
            for(j in 0 until (2 * n - i)) {
                bw.write("*")
            }
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}