package ryute.topic01.sub01

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution02()
}

// 시간초과
private fun solution01() {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    repeat(n) {
        list.add(readLine()!!.toInt())
    }
    list.sort()
    list.forEach { println(it) }
}

private fun solution02() {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    val builder = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(n) {
        list.add(readLine()!!.toInt())
    }
    list.sort()
    list.forEach { builder.append("$it\n") }
    bw.write(builder.toString())
    bw.flush()
    bw.close()
}