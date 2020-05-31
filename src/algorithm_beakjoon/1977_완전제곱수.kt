package src.algorithm_beakjoon

import java.util.*

// 200531
// 1977 - 완전제곱수

fun main() {
    with(Scanner(System.`in`)) {
        val (m, n) = nextInt() to nextInt()
        val list = Array(100){ i -> (i + 1) * (i + 1) }
        val ans = mutableListOf<Int>()

        for(i in m..n) if(i in list) ans.add(i)

        if(ans.isEmpty()) println(-1)
        else {
            var sum = 0
            for(i in ans) sum += i
            println(sum)
            println(ans.first())
        }
    }
}