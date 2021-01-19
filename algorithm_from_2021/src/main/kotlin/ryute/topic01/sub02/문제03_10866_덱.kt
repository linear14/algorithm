package ryute.topic01.sub02

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val n = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val linkedList = LinkedList<Int>()

    repeat(n) {
        val command = readLine()!!.split(" ")

        when(command[0]) {
            "push_front" -> {
                linkedList.push(command[1].toInt())
            }
            "push_back" -> {
                linkedList.add(command[1].toInt())
            }
            "pop_front" -> {
                bw.write("${linkedList.pollFirst()?:-1}\n")
            }
            "pop_back" -> {
                bw.write("${linkedList.pollLast()?:-1}\n")
            }
            "size" -> {
                bw.write("${linkedList.size}\n")
            }
            "empty" -> {
                if(linkedList.isEmpty()) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }
            "front" -> {
                bw.write("${linkedList.peekFirst()?:-1}\n")
            }
            "back" -> {
                bw.write("${linkedList.peekLast()?:-1}\n")
            }
        }
    }

    bw.flush()
    bw.close()
}