package ryute.topic02.sub03

import kotlin.math.abs

private var n: Int = 0
private var m: Int = 0
private lateinit var city: Array<IntArray>
private val housePosition: MutableList<Pair<Int, Int>> = mutableListOf()
private val storePosition: MutableList<Pair<Int, Int>> = mutableListOf()
private lateinit var storeVisited: Array<Boolean>

private var minChickenLength = Int.MAX_VALUE

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.apply {
        n = get(0)
        m = get(1)
    }

    city = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    for(i in 0 until n) {
        for(j in 0 until n) {
            when(city[i][j]) {
                1 -> housePosition.add(Pair(i, j))
                2 -> storePosition.add(Pair(i, j))
            }
        }
    }
    storeVisited = Array(storePosition.size) { false }

    backTracking(0, 0)
    println(minChickenLength)
}


private fun backTracking(start: Int, level: Int) {
    if(level == m) {
        var chickenLength = 0
        for(i in housePosition) {
            chickenLength += getMinChickenLength(i)
        }
        if(chickenLength < minChickenLength) {
            minChickenLength = chickenLength
        }
        return
    }

    for(i in start until storePosition.size) {
        storeVisited[i] = true
        backTracking(i + 1, level + 1)
        storeVisited[i] = false
    }
}

private fun getMinChickenLength(housePosition: Pair<Int, Int>): Int {
    var minLength = Int.MAX_VALUE

    for(i in 0 until storePosition.size) {
        if(storeVisited[i]) {
            var distance = abs(housePosition.first - storePosition[i].first) + abs(housePosition.second - storePosition[i].second)
            if(distance < minLength) {
                minLength = distance
            }
        }
    }

    return minLength
}
