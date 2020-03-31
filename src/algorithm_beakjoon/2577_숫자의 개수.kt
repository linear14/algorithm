package algorithm_beakjoon

import java.io.*

// 200331
// 2577 - 숫자의 개수

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val ansList = MutableList(10) {0}
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()

    val mulResult = a * b * c
    val str = mulResult.toString()

    for(i in str) {
        ansList[i.toString().toInt()]++
    }

    for(i in ansList) {
        bw.write("$i\n")
    }
    bw.flush()
}