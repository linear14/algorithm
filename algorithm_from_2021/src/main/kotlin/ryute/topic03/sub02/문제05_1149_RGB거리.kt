package ryute.topic03.sub02

import java.lang.Integer.min

private fun main() {
    val n = readLine()!!.toInt()
    val rgb = Array(n) { readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }

    for(i in 1 until n) {
        for(j in 0..2) {
            rgb[i][j] += min(rgb[i-1][(j+1)%3], rgb[i-1][(j+2)%3])
        }
    }

    println(rgb[n-1].minOrNull())
}