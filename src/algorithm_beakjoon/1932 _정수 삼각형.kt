package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.max

// 200519
// 1932 - 정수 삼각형

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val board = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }

    for(i in 1 until n) {
        for(j in board[i].indices) {
            when (j) {
                0                 -> board[i][j] += board[i-1][j]
                board[i].size - 1 -> board[i][j] += board[i-1][j-1]
                else              -> board[i][j] += max(board[i-1][j-1], board[i-1][j])
            }
        }
    }

    bw.write(board[n-1].max().toString())
    bw.flush()
}