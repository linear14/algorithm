package algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200403
// 4948 - 베르트랑 공준

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while(true) {
        val num = readLine()!!.toInt()
        if(num == 0) break

        val array = Array(2 * num + 1) { 0 }
        array[1] = 1

        for(i in 2..2*num) {
            if(array[i] != 0) continue
            for(j in 2*i..2*num step i) array[j]++
        }

        var answer = 0
        for(i in array.indices) {
            if(array[i] == 0 && i > num) answer++
        }
        bw.write("$answer\n")
    }
    bw.flush()

}
