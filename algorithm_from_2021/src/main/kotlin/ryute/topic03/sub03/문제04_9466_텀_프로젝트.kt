package ryute.topic03.sub03

import java.util.*

private fun main() {
    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()
        val input = readLine()!!.split(" ").map { it.toInt() }
        val nomi = Array(n + 1) { i -> if(i==0) 0 else input[i-1] }
        val isNotTeam = BooleanArray(n + 1)
        val isTeam = BooleanArray(n + 1)

        for(i in 1..n) {
            val s = Stack<Int>()
            val isVisited = BooleanArray(n + 1)

            var next = i

            a@while(true) {
                if(isVisited[next]) {
                    var teamFlag = true
                    while(s.isNotEmpty()) {
                        val target = s.pop()
                        if(teamFlag) {
                            isTeam[target] = true
                        } else {
                            isNotTeam[target] = true
                        }

                        if(target == next) {
                            teamFlag = false
                        }
                    }
                    break@a
                }

                if(isTeam[next]) {
                    while(s.isNotEmpty()) {
                        val target = s.pop()
                        isNotTeam[target] = true
                    }
                    break@a
                }

                if(isNotTeam[next]) {
                    while(s.isNotEmpty()) {
                        val target = s.pop()
                        isNotTeam[target] = true
                    }
                    break@a
                }

                s.add(next)
                isVisited[next] = true
                next = nomi[next]
            }

        }

        println(n - isTeam.count { it })
    }
}