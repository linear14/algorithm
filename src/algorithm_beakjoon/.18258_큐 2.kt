package algorithm_beakjoon

import java.io.*

// 200411 ~ 200413
// 18258 - 큐 2

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var n = br.readLine().toInt()
    val builder = StringBuilder()
    val list = mutableListOf<Int>()
    var front = 0
    var rear = -1

    while(n-- > 0) {
        val input = br.readLine().split(" ")

        when(input[0]) {
            "push" -> {
                list.add(input[1].toInt())
                rear++
            }
            "pop" -> {
                if(front > rear) builder.append("-1\n")
                else {
                    builder.append("${list[front]}\n")
                    front++
                }
            }
            "size" -> {
                builder.append("${rear - front + 1}\n")
            }
            "empty" -> {
                if(front > rear) builder.append("1\n")
                else builder.append("0\n")
            }
            "front" -> {
                if(front > rear) builder.append("-1\n")
                else builder.append("${list[front]}\n")
            }
            "back" -> {
                if(front > rear) builder.append("-1\n")
                else builder.append("${list[rear]}\n")
            }
        }
    }

    bw.write(builder.toString())
    bw.flush()
}