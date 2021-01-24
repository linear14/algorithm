package ryute.topic01.sub03

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution01()
}

// map의 containsKey 메서드, replace 메서드도 사용해보기
/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val cards = hashMapOf<Int, Int>()

    readLine()
    readLine()!!.split(" ").map { it.toInt() }.forEach {
        val oldCnt = cards[it]?:0
        cards[it] = oldCnt + 1
    }

    readLine()
    readLine()!!.split(" ").map { it.toInt() }.forEach {
        bw.write("${cards[it]?:0} ")
    }

    bw.flush()
    bw.close()
}