package ryute.topic02.sub01

import kotlin.math.abs

private var n: Int = 0
private var ans: Int = 0
private var array = arrayOf<Int>()

private fun main() {
    n = readLine()!!.toInt()
    array = Array(n) { 0 }

    backTracking(0)
    println(ans)
}

private fun backTracking(level: Int) {
    if(level >= n) {
        ans++
        /*for(i in array) {
            print("$i ")
        }
        println()*/
        return
    }

    for(i in 0 until n) {
        array[level] = i
        if(isPossible(level)) backTracking(level + 1)
        array[level] = 0
    }
}

private fun isPossible(level: Int): Boolean {
    for(i in 0 until level) {
        if(array[i] == array[level]) return false
        if(abs(array[i] - array[level]) == abs(i - level)) return false
    }

    return true
}