package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

// 200415 ~ 200425
// 2447 - 별 찍기 - 10

/*

        재귀 진짜 ㅋㅋㅋ ㅠㅠ
        시작 인덱스와 끝 인덱스의 차이를 계속 3으로 나누어 처리하고..
        그 값이 0이 되면 재귀 호출의 끝으로 인식해서 처리했음..

        코드 보면 이해가 될 수도..?
        영상으로 과정을 남겨야겠다.

 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val builder = StringBuilder()

    val n = br.readLine().toInt()

    val board = MutableList(n + 1) { MutableList(n + 1) { "*" } }

    fun makeBlank(startX: Int, endX: Int, startY: Int, endY: Int) {
        val intervalDivThree = (endX - startX + 1) / 3
        if (intervalDivThree == 0) return

        for (i in startX + intervalDivThree until startX + intervalDivThree * 2) {
            for (j in startY + intervalDivThree until startY + intervalDivThree * 2) {
                board[i][j] = " "
            }
        }

        for (i in startX..endX step intervalDivThree) {
            for (j in startY..endY step intervalDivThree) {
                makeBlank(i, i + intervalDivThree - 1, j, j + intervalDivThree - 1)
            }
        }
    }

    makeBlank(1, n, 1, n)

    for (i in 1 until board.size) {
        for (j in 1 until board.size) {
            builder.append(board[i][j])
        }
        builder.append("\n")
    }

    bw.write(builder.toString())
    bw.flush()
}