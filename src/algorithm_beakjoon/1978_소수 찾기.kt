package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200402
// 1978 - 소수 찾기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ")
    val notSosus = mutableListOf<Int>()
    notSosus.add(1)
    for(i in 2..1000) {
        if(i !in notSosus) {
            var num = i
            while(num <= 1000) {
                num += i
                if(num !in notSosus) {
                    notSosus.add(num)
                }
            }
        }
    }

    var iToInt: Int
    var count = 0

    for(i in list) {
        iToInt = i.toInt()
        if(iToInt !in notSosus) {
            count++
        }
    }

    bw.write(count.toString())
    bw.flush()
}