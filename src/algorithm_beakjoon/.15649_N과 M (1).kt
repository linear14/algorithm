package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 다시 학습한 백 트래킹 이용
// 200511
// 15649 - N과 M (1)

fun main() {
    val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
    val answer = Array(m){ 0 }

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(answer[level] == answer[i]) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == m) {
            for(i in answer) print("$i ")
            println()
        } else {
            for(i in 1 .. n) {
                answer[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }

    }

    backTracking(0)

}


// 처음 시도했던 백 트래킹
// 200416
// 15649 - N과 M (1)


// DFS 익히는 용도..
// 백트래킹.. 어렵다..

/*fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val builder = StringBuilder()
    lateinit var answer: Array<Int>
    lateinit var check: Array<Boolean>

    fun dfs(n: Int, m: Int, now: Int) {
        var start = 1
        if(now == m) {
            for(i in answer) {
                builder.append("$i ")
            }
            builder.append("\n")
            return
        }

        while(start <= n) {
            if(!check[start]) {
                answer[now] = start
                check[start] = true
                dfs(n, m, now + 1)
                check[start] = false
            }
            start++
        }
    }

    val input = br.readLine().split(" ")
    val (n, m) = input[0].toInt() to input[1].toInt()

    answer = Array(m) { 0 }
    check = Array(n + 1) { false }

    dfs(n, m, 0)
    bw.write(builder.toString())
    bw.flush()
}*/
