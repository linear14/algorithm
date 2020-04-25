package src.algorithm_beakjoon

import java.util.*

// 200425
// 2822 - 점수 계산

fun main() = with(Scanner(System.`in`)) {
    val list = Array(8) { i -> Pair(i + 1, nextInt())}
    val indexList = arrayListOf<Int>()
    var total = 0

    list.sortWith(Comparator { p1, p2 ->
        p2.second - p1.second
    })

    for(i in 0 until 5) {
        total += list[i].second
        indexList.add(list[i].first)
    }
    indexList.sort()

    println(total)
    for(i in indexList) print("$i ")
}