package ryute.topic03.sub03

import java.util.*

private var m = 0
private var n = 0
private var h = 0

private lateinit var box: Array<Array<IntArray>>
private lateinit var isVisited: Array<Array<BooleanArray>>
private var q = LinkedList<IntArray>() // h, n, m 순으로 저장

private var ans = 0

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    h = input[2]

    box = Array(h) { Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() } }
    isVisited = Array(h) { Array(n) { BooleanArray(m) } }

    for(i in 0 until h) {
        for(j in 0 until n) {
            for(k in 0 until m) {
                if(box[i][j][k] == 1) {
                    q.add(intArrayOf(i, j, k))
                    isVisited[i][j][k] = true
                }
            }
        }
    }

    bfs()

    l@for(i in 0 until h) {
        for(j in 0 until n) {
            for(k in 0 until m) {
                if(box[i][j][k] == 0) {
                    ans = -1
                    break@l
                }
            }
        }
    }

    println(ans)
}

private fun bfs() {

    while(q.isNotEmpty()) {
        val size = q.size

        repeat(size) {
            val current = q.poll()
            val ch = current[0]
            val cl = current[1]
            val cr = current[2]

            goNextIfPossible(ch - 1, cl, cr)
            goNextIfPossible(ch + 1, cl, cr)
            goNextIfPossible(ch, cl - 1, cr)
            goNextIfPossible(ch, cl + 1, cr)
            goNextIfPossible(ch, cl, cr - 1)
            goNextIfPossible(ch, cl, cr + 1)
        }

        if(q.isNotEmpty()) ans++
    }
}

private fun goNextIfPossible(nh: Int, nl: Int, nr: Int) {
    if(nh in 0 until h && nl in 0 until n && nr in 0 until m) {
        if(!isVisited[nh][nl][nr] && box[nh][nl][nr] == 0) {
            box[nh][nl][nr] = 1
            q.add(intArrayOf(nh, nl, nr))
            isVisited[nh][nl][nr] = true
        }
    }
}