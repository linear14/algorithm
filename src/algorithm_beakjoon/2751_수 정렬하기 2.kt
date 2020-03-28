package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200328
// 2751 : 수 정렬하기 2

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = MutableList(n) {br.readLine().toInt()}
    list.sort()

    for(i in list){
        bw.write("$i\n")
    }
    bw.flush()
}


// 1차 제출 ( 실패 - 시간초과 )

/*
fun heapify(list: MutableList<Int>, start: Int, end: Int) {
    for(i in start .. end) {
        var child = i
        while (child > 0) {
            var root = (child - 1) / 2

            if (list[root] < list[child]) {
                val temp = list[root]
                list[root] = list[child]
                list[child] = temp
            }
            child = root
        }
    }
}

fun heapSort(list: MutableList<Int>, start: Int, end: Int) {
    var end = end

    do {
        heapify(list, start, end)
        val max = list[start]
        list[start] = list[end]
        list[end] = max
    } while(--end >= 0)
}
*/
