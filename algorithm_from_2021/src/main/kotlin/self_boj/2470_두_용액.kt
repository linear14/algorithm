package self_boj

import kotlin.math.abs

private var n = 0
private lateinit var arr: Array<Solution>

private data class Solution(val spec: Int, val isAcid: Boolean)

private fun main() {
    n = readLine()!!.toInt()
    arr = readLine()!!.split(" ")
            .map {
                val isAcid = !it.startsWith('-')
                Solution(abs(it.toInt()), isAcid)
            }
            .sortedBy { it.spec }
            .toTypedArray()

    var ans = Pair(0, Int.MAX_VALUE)
    for(i in 0 until arr.size - 1) {
        val (sol1, sol2) = parseSolution(arr[i]) to parseSolution(arr[i + 1])
        val sum = sol1 + sol2

        if(abs(ans.first + ans.second) >= abs(sum)) {
            ans = Pair(sol1, sol2)
        }
    }

    if(ans.first < ans.second) {
        print("${ans.first} ${ans.second}")
    } else {
        print("${ans.second} ${ans.first}")
    }

}

private fun parseSolution(sol: Solution): Int {
    return if(sol.isAcid) sol.spec
    else sol.spec * -1
}