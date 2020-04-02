package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200402
// 1065 - 한수

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var str: String
    var count = 0

    a@ for(i in 1..n) {
        when (i) {
            in 1..99 -> count++
            1000 -> break@a
            else -> {
                str = i.toString()
                if(str[1] - str[0] == str[2] - str[1]) {
                    count++
                }
            }
        }
    }
    bw.write(count.toString())
    bw.flush()
}