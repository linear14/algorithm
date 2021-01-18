package ryute.topic01.sub02

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val linkedList = LinkedList<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()!!.toInt()
    repeat(n) {
        val command = readLine()!!.split(" ")

        when(command[0]) {
            "push" -> {
                linkedList.add(command[1].toInt())
            }
            "pop" -> {
                bw.write("${linkedList.pollFirst()?:-1}\n")
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