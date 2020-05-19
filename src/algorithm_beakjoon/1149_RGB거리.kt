package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.min

// 200519
// 1149 - RBG거리
// https://mingyeongun-dev.tistory.com/30 에서 힌트를 얻었다.
// (다이나믹 프로그래밍 개념 습득을 위한 문제)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val board = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray()}

    for(i in 1 until n) {
        board[i][0] += min(board[i-1][1], board[i-1][2])
        board[i][1] += min(board[i-1][0], board[i-1][2])
        board[i][2] += min(board[i-1][0], board[i-1][1])
    }

    bw.write(board[n-1].min().toString())
    bw.flush()
}