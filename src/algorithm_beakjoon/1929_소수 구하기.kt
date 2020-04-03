package algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200403
// 1929 - 소수 구하기

/*
        소수를 구하기에 정말 괜찮은 방법이라고 생각했음
        내가 알아보고 싶은 수의 범위에 맞게 동적으로 값 범위를 설정 가능하게 구현했기 때문에
        불필요한 메모리 낭비도 없다고 생각함
 */

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val mn = readLine()!!.split(" ")
    val (m, n) = mn[0].toInt() to mn[1].toInt()

    val numberList = MutableList(n + 1){ 0 }
    numberList[0] = 1
    numberList[1] = 1

    // 소수가 아니면 1 추가
    for(i in 1..n) {
        if(numberList[i] != 0) continue
        for(j in (i + i)..n step i) numberList[j]++
    }

    for((i, element) in numberList.withIndex()) {
        if(element == 0 && i >= m) bw.write("$i\n")
    }
    bw.flush()
}