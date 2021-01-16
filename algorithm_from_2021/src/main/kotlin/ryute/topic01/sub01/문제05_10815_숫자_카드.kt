package ryute.topic01.sub01

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution03()
}

// sort 하지 말고 진행
// 이후 이진검색법 (루트N)
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    readLine()
    val list = readLine()!!.split(" ").map { it.toInt() }
    readLine()
    readLine()!!.split(" ").forEach {
        if(it.toInt() in list) { sb.append("1 ") }
        else { sb.append("0 ") }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

/*
    시간제한 2초 -> 200,000,000
    sort 진행을 해보면 -> (NlogN) 500,000 * 5.xx = 2,500,000 ~ 3,000,000
    이후 이진검색 (최대 500,000개) 2^X = M --> X = LogM
    --> 시간복잡도 최대 (500,000 * Log(10,000,000))
    --> 3,500,000 정도
    종합적으로 2초 내에는 무조건 가능하다는 결론
 */
/*** 정답 코드 ***/
private fun solution02() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    readLine()
    val list = readLine()!!.split(" ").map { it.toInt() }.sorted()

    readLine()
    readLine()!!.split(" ").forEach {
        if(search(list, it.toInt())) { sb.append("1 ") }
        else { sb.append("0 ") }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

private fun search(list: List<Int>, num: Int): Boolean {
    var start = 0
    var end = list.size - 1

    while(start <= end) {
        val middle = (start + end) / 2
        when(num) {
            list[middle] -> return true
            in -10_000_000 until list[middle] -> {
                end = middle - 1
            }
            in list[middle] + 1 .. 10_000_000 -> {
                start = middle + 1
            }
        }
    }
    return false
}

/*
    (youngjun08300 님의 풀이 참고) [https://www.acmicpc.net/source/23927659]
    이런 생각도 할 수 있구나..
 */
/*** 정답 코드 2 ***/
private fun solution03() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val plusArray = Array(10_000_001) { 0 }
    val minusArray = Array(10_000_001) { 0 }

    readLine()
    readLine()!!.split(" ").forEach {
        val num = it.toInt()
        if(num >= 0) { plusArray[num] = 1 }
        else { minusArray[num * -1] = 1 }
    }
    readLine()
    readLine()!!.split(" ").forEach {
        val num = it.toInt()
        if(num >= 0) { sb.append("${plusArray[num]} ") }
        else { sb.append("${minusArray[num * -1]} ") }
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

