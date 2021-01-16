package ryute.topic01.sub01

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    solution04()
}

// 메모리 초과
private fun solution01() {
    val n = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stringBuilder = StringBuilder()

    val list = mutableListOf<Int>().apply {
        repeat(n) {
            add(readLine()!!.toInt())
        }
    }

    list.sort()
    list.forEach {
        stringBuilder.append("$it\n")
    }
    bw.write(stringBuilder.toString())
    bw.flush()
    bw.close()
}

// 메모리 초과.. Int 리스트를 담아서 문제가 되었던 것이라 생각하고 short를 사용했지만 여전히 실패
private fun solution02() {
    val n = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stringBuilder = StringBuilder()

    val list = mutableListOf<Short>().apply {
        repeat(n) {
            add(readLine()!!.toShort())
        }
    }

    list.sort()
    list.forEach {
        stringBuilder.append("$it\n")
    }
    bw.write(stringBuilder.toString())
    bw.flush()
    bw.close()
}

// 2000만 바이트 (short로 문제를 풀었을 경우..)
// 1킬로바이트 = 1024 바이트
// 1메가바이트 = 1000000 바이트 -> 8메가바이트 800만 바이트......??!
// 10000이 천만개 있으면 어떻게 되냐~~ --> 2바이트 x 천만 = 2천만바이트 = 20 * 10^3 * 10^3 = 20 메가바이트 = 20000 바이트


// 메모리를 모두 사용하지 않도록 나누어서 풀어야한다..

// 카운팅소트..? 뭐 그런게 있었는데 ㅎㅎ;; 뭐였지? 그건 시간 복잡도를 줄이는 알고리즘이었는데 이건 아니다.. 는 아니다
// 10000개의 short형 숫자 --> 20000바이트 --> 20킬로바이트..!
// 입력받은 숫자의 갯수를 세어주는 방식..!!

// 시간초과!! 다왔다이제
private fun solution03() {
    val n = readLine()!!.toInt()
    val array = Array(10001){ 0 }

    repeat(n) {
        array[readLine()!!.toInt()]++
    }

    for(i in 1..10000) {
        if(array[i] != 0) {
            for(j in 1..array[i]) {
                println(i)
            }
        }
    }
}

/*** 정답 코드 ***/
private fun solution04() {
    val n = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = Array(10001){ 0 }

    repeat(n) {
        array[readLine()!!.toInt()]++
    }

    for(i in 1..10000) {
        if(array[i] != 0) {
            repeat(array[i]) {
                bw.write("$i\n")
            }
        }
    }
    bw.flush()
    bw.close()
}
