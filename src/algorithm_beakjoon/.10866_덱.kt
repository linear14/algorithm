package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200423
// 10866 - 덱

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val list = LinkedList<Int>()

    repeat(br.readLine().toInt()) {
        val command = br.readLine().split(" ")

        when(command[0]) {
            "push_front" -> {
                list.push(command[1].toInt())
            }
            "push_back" -> {
                list.add(command[1].toInt())
            }
            "pop_front" -> {
                if(list.isEmpty()) bw.write("-1\n")
                else bw.write("${list.poll()}\n")
            }
            "pop_back" -> {
                if(list.isEmpty()) bw.write("-1\n")
                else bw.write("${list.pollLast()}\n")
            }
            "size" -> {
                bw.write("${list.size}\n")
            }
            "empty" -> {
                if(list.isEmpty()) bw.write("1\n")
                else bw.write("0\n")
            }
            "front" -> {
                if(list.isEmpty()) bw.write("-1\n")
                else bw.write("${list.peek()}\n")
            }
            "back" -> {
                if(list.isEmpty()) bw.write("-1\n")
                else bw.write("${list.peekLast()}\n")
            }

        }
    }

    bw.flush()
}
