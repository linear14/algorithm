package algorithm_beakjoon

import java.io.*

// 200328
// 10989 - 수 정렬하기 3

// 2차 풀이 - Counting sort
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val array = Array(n){br.readLine().toInt()}
    val count = Array(10001){0}

    for(i in array) {
        count[i]++
    }

    for(i in count.indices) {
            for(j in 1..count[i]) {
            bw.write("${i}\n")
        }
    }
    bw.flush()
}



// 1차 오답 (Heap 정렬을 이용한 풀이 - 시간 초과)
// 하지만 아이디어는 괜찮다고 생각해서 남겨 둠

/*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val array = Array(n){br.readLine().toInt()}
    heapSort(array, 0, n - 1)

    for(i in array) {
        bw.write("${i}\n")
    }
    bw.flush()
}

fun heapify(array: Array<Int>, start: Int, end: Int) {
    val middle = (start + end - 1) / 2
    for(i in start..middle) {
        var child = i
        while(child > 0) {
            var root = (child - 1) / 2

            if (array[root] < array[child]) {
                val temp = array[root]
                array[root] = array[child]
                array[child] = temp
            }
            child = root
        }
    }

}

fun heapSort(array: Array<Int>, start: Int, end: Int) {
    var end = end
    while(end-- > 0) {
        val tempMax = array[start]
        array[start] = array[end]
        array[end] = tempMax

        heapify(array, start, end)
    }
}
*/

