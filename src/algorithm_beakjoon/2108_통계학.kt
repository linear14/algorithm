package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200329
// 2108 - 통계학

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = MutableList(n){br.readLine().toInt()}
    val sortedList = mutableListOf<Int>()
    val count = Array(8001){0}

    var sum = 0
    var modeCount = -9999
    val modeList = mutableListOf<Int>()

    for(i in list) {
        sum += i
        count[i + 4000]++
    }

    for(i in count.indices) {
        for(j in 1..count[i]) {
            sortedList.add(i - 4000)
        }
    }

    // 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
    bw.write(String.format("%.0f", sum / n.toDouble()))

    // 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    bw.write("\n${sortedList[n / 2]}")

    // 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
    for(i in count) {
        if(i > 0 && modeCount < i) {
            modeCount = i
        }
    }

    for(i in count.indices) {
         if(count[i] == modeCount) {
             modeList.add(i - 4000)
        }
        if(modeList.size == 2) {
            break
        }
    }
    if(modeList.size == 1) {
        bw.write("\n${modeList[0]}")
    } else {
        bw.write("\n${modeList[1]}")
    }

    // 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
    bw.write("\n${sortedList[n - 1] - sortedList[0]}")
    bw.flush()
}
