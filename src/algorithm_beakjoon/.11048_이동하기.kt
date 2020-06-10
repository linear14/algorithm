package src.algorithm_beakjoon

import kotlin.math.max

// 200610
// 11048 - 이동하기

fun main() {
    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val miro = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }

    for(j in 1 until m) miro[0][j] += miro[0][j-1]
    for(i in 1 until n) miro[i][0] += miro[i-1][0]

    for(i in 1 until n) {
        for(j in 1 until m) {
            var max = miro[i-1][j-1]
            val temp = max(miro[i-1][j], miro[i][j-1])
            if(max < temp) max = temp

            miro[i][j] += max
        }
    }

    print(miro[n-1][m-1])
}