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
