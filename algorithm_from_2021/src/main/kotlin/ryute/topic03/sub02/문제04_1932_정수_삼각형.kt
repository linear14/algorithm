package ryute.topic03.sub02

import java.lang.Integer.max

private var n = 0
private lateinit var tr: Array<IntArray>

private fun main() {

    n = readLine()!!.toInt()
    tr = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    for(i in 1 until n) {
        for(j in tr[i].indices) {
            val current = tr[i][j]
            tr[i][j] = when (j) {
                0 -> {
                    tr[i-1][j] + current
                }
                tr[i].size - 1 -> {
                    tr[i-1][j-1] + current
                }
                else -> {
                    max(tr[i-1][j-1], tr[i-1][j]) + current
                }
            }
        }
    }

    println(tr[n-1].maxOrNull())
}