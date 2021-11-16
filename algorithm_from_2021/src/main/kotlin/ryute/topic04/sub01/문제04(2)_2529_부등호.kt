package ryute.topic04.sub01

// https://sihyungyou.github.io/baekjoon-2529/
// 위에 보면서 다시 생각해보기

import java.lang.StringBuilder

private var k = 0
private lateinit var cmds: List<String>

private fun main() {
    k = readLine()!!.toInt()
    cmds = readLine()!!.split(" ")

    findLargest()
    findSmallest()
}

private fun findLargest() {
    val sb = StringBuilder()

    var start = 9
    var cnt = 0

    for(cmd in cmds) {
        if(cmd == "<") {
            cnt++
            continue
        }

        start -= cnt
        for(i in 0..cnt) {
            sb.append(start + i)
        }

        start--
        cnt = 0
    }

    val remain = (k + 1) - sb.toString().length
    for(i in 0 until remain){
        sb.append(i)
    }

    println(sb.toString())
}

private fun findSmallest() {
    val sb = StringBuilder()

    var start = 0
    var cnt = 0

    for(cmd in cmds) {

        if(cmd == ">") {
            cnt++
            continue
        }

        start += cnt
        for(i in 0..cnt) {
            sb.append(start - i)
        }

        start++
        cnt = 0
    }

    val remain = (k + 1) - sb.toString().length
    for(i in 0 until remain){
        sb.append(k - i)
    }

    println(sb.toString())
}

