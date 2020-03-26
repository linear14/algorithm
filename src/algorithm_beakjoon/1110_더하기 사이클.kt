package algorithm_beakjoon

import java.io.*

// 200326
// 1110 - 더하기 사이클

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val start = br.readLine()
    var newNumber = start.toInt()
    var count = 0

    do {
        val first = newNumber / 10
        val second = newNumber % 10

        newNumber = (second * 10) + ((first + second) % 10)
        count++
    } while(start.toInt() != newNumber)

    bw.write("$count")
    bw.flush()
}