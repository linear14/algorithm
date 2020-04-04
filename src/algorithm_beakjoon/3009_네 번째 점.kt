package algorithm_beakjoon

import java.util.*

// 200404
// 3009 - 네 번째 점

fun main() {
    val sc = Scanner(System.`in`)
    val arrayX = mutableListOf<Int>()
    val arrayY = mutableListOf<Int>()

    while(sc.hasNextInt()) {
        arrayX.add(sc.nextInt())
        arrayY.add(sc.nextInt())
    }

    when {
        arrayX[0] == arrayX[1] -> print("${arrayX[2]} ")
        arrayX[0] == arrayX[2] -> print("${arrayX[1]} ")
        else -> print("${arrayX[0]} ")
    }

    when {
        arrayY[0] == arrayY[1] -> print("${arrayY[2]}")
        arrayY[0] == arrayY[2] -> print("${arrayY[1]}")
        else -> print("${arrayY[0]}")
    }
}
