package src.algorithm_beakjoon

import java.util.*

// 200423
// 1966 - 프린터 큐

fun main() {
    with(Scanner(System.`in`)) {
        repeat(nextInt()) {
            var (n, point) = nextInt() to nextInt()

            val list = LinkedList<Int>()
            for(i in 0 until n) list.add(nextInt())
            var flag = true
            var answer = 0

            while(flag) {
                val max = list.max()
                val delete = list.poll()

                if(delete == max) {
                    if(point == 0) {
                        flag = false
                        answer++
                    } else {
                        point--
                        answer++
                    }
                } else {
                    if(point == 0) {
                        point = list.size
                    } else {
                        point--
                    }
                    list.add(delete)
                }

            }
            println(answer)
        }
    }
}
