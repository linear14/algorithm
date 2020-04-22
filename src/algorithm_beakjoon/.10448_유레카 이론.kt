package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200422
// 10448 - 유레카 이론

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val list = arrayListOf<Int>()

    var tNum = 0
    var index = 1
    while(tNum <= 1000) {
        tNum += index
        index++
        list.add(tNum)
    }


    var t = br.readLine().toInt()
    while(t-- > 0) {
        var ans = 0
        val k = br.readLine().toInt()

        a@for(i in 0 until list.size) {
            for(j in i until list.size) {
                for(m in j until list.size) {
                    if(m >= k) break
                    if(list[i] + list[j] + list[m] == k) {
                        ans = 1
                        break@a
                    }
                }
                if(j >= k) break
            }
            if(i >= k) break
        }
        bw.write("$ans\n")
    }
    bw.flush()
}