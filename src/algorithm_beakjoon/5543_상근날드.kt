package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200327
// 5543 - 상근날드

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val burgers = Array(3) {br.readLine().toInt()}
    val drinks = Array(2) {br.readLine().toInt()}


    var min_burgers = 10000
    var min_drinks = 10000

    for(i in burgers) {
        if(i < min_burgers) {
            min_burgers = i
        }
    }

    for(i in drinks) {
        if(i < min_drinks) {
            min_drinks = i
        }
    }

    bw.write((min_burgers + min_drinks - 50).toString())
    bw.flush()
    bw.close()
}