package ryute.topic01.sub03

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution03()
}

// 이게 되네
/*** 정답 코드 ***/
private fun solution01() {
    val n = readLine()!!.toInt()
    val wordSet = hashSetOf<String>().apply {
        repeat(n) {
            add(readLine()!!)
        }
    }.toMutableList()
            .sorted()
            .sortedBy { it.length }
            .forEach {
                println(it)
            }

}

// BufferedWriter 사용 시 시간 단축이 얼마나 되는지 확인 --> 836 -> 564ms
/*** 정답 코드 ***/
private fun solution02() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val n = readLine()!!.toInt()
    val wordSet = hashSetOf<String>().apply {
        repeat(n) {
            add(readLine()!!)
        }
    }.toMutableList()
            .sorted()
            .sortedBy { it.length }
            .forEach {
                sb.append("$it\n")
            }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

// Comparator 사용해보기
/*** 정답 코드 ***/
private fun solution03() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val n = readLine()!!.toInt()
    val wordList = hashSetOf<String>().apply {
        repeat(n) {
            add(readLine()!!)
        }
    }.toMutableList()
            .apply {
                sortWith { v1, v2 ->
                    if (v1.length == v2.length) {
                        var indexDiff = 0
                        for (i in 0..v1.length) {
                            if (v1[i] == v2[i]) {
                                continue
                            } else {
                                indexDiff = i
                                break
                            }
                        }
                        v1[indexDiff] - v2[indexDiff]
                    } else {
                        v1.length - v2.length
                    }
                }
            }
            .forEach {
                sb.append("$it\n")
            }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}