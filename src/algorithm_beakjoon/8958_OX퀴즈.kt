package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200331
// 8958 - OX퀴즈

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    while(n-- > 0) {
        val stack = Stack<Char>()
        val result = br.readLine()
        var totalScore = 0

        for (i in result) {
            if (i == 'O') {
                stack.push(i)
            } else {
                totalScore += (stack.size * (stack.size + 1)) / 2
                stack.clear()
            }
        }
        totalScore += (stack.size * (stack.size + 1)) / 2

        bw.write("$totalScore\n")
    }
    bw.flush()
}