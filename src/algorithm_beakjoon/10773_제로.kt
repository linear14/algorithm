package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200330
// 10773 - 제로

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var k = br.readLine().toInt()
    val s = Stack<Int>()
    var sum = 0

    while(k-- > 0){
        val input = br.readLine().toInt()
        if(input == 0) {
            s.pop()
        } else {
            s.push(input)
        }
    }

    while(s.isNotEmpty()) {
        sum += s.pop()
    }

    bw.write("$sum")
    bw.flush()
}
