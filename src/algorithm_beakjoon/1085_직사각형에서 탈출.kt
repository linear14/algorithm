package algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200404
// 1085 - 직사각형에서 탈출

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = readLine()!!.split(" ")
    val x = input[0].toInt()
    val y = input[1].toInt()
    val w = input[2].toInt()
    val h = input[3].toInt()

    // 4개의 사분면으로 나누기 (센터 포인트를 기준으로 1 ~ 4 사분면 순차적으로)
    val widthCenter = w / 2
    val heightCenter = h / 2
    when {
        widthCenter < x && heightCenter < y -> {
            bw.write(shortestLength(w - x, h - y))
        }
        widthCenter >= x && heightCenter < y -> {
            bw.write(shortestLength(x, h - y))
        }
        widthCenter >= x && heightCenter >= y -> {
            bw.write(shortestLength(x, y))
        }
        widthCenter < x && heightCenter >= y -> {
            bw.write(shortestLength(w - x, y))
        }
    }
    bw.flush()
}

fun shortestLength(x: Int, y: Int) = if(x < y) x.toString() else y.toString()
