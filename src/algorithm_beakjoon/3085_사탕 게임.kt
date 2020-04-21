package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200421
// 3085 - 사탕 게임

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val list = MutableList(n) { MutableList(n) { "" } }

    for(i in 0 until n) {
        val line = br.readLine()!!
        for(j in 0 until n) {
            list[i][j] = line[j].toString()
        }
    }

    var answerCount = 1

    for(i in 0 until n) {
        for(j in 0 until n - 1) {
            if(list[i][j] != list[i][j + 1]) {
                var temp = list[i][j]
                list[i][j] = list[i][j + 1]
                list[i][j + 1] = temp

                val maxIt = findMaxCandyCount(list)
                if (answerCount < maxIt) answerCount = maxIt

                temp = list[i][j]
                list[i][j] = list[i][j + 1]
                list[i][j + 1] = temp
            }

            if(list[j][i] != list[j + 1][i]) {
                var temp = list[j][i]
                list[j][i] = list[j + 1][i]
                list[j + 1][i] = temp

                val maxIt = findMaxCandyCount(list)
                if (answerCount < maxIt) answerCount = maxIt

                temp = list[j][i]
                list[j][i] = list[j + 1][i]
                list[j + 1][i] = temp
            }
        }
    }

    bw.write(answerCount.toString())
    bw.flush()
}

fun findMaxCandyCount(list: MutableList<MutableList<String>>): Int {
    var max = 1
    var tempMax = 1
    for(i in 0 until list.size - 1) {
        for(j in 0 until list.size - 1) {
            if(list[i][j] == list[i][j + 1]) {
                tempMax++
                if(max < tempMax) max = tempMax
            } else {
                tempMax = 1
            }
        }
        tempMax = 1
    }

    for(i in 0 until list.size - 1) {
        for(j in 0 until list.size - 1) {
            if(list[j][i] == list[j + 1][i]) {
                tempMax++
                if(max < tempMax) max = tempMax
            } else {
                tempMax = 1
            }
        }
        tempMax = 1
    }

    return max
}