package ryute.topic01.sub02

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Int>()
    val n = readLine()!!.toInt()

    repeat(n) {
        val command = readLine()!!.split(" ")

        when (command[0]) {
            "push" -> {
                stack.push(command[1].toInt())
            }
            "pop" -> {
                if(stack.isEmpty()) {
                    bw.write("-1\n")
                } else {
                    bw.write("${stack.pop()}\n")
                }
            }
            "size" -> {
                bw.write("${stack.size}\n")
            }
            "empty" -> {
                if(stack.isEmpty()) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }
            "top" -> {
                if(stack.isEmpty()) {
                    bw.write("-1\n")
                } else {
                    bw.write("${stack.peek()}\n")
                }
            }
        }
    }

    bw.flush()
    bw.close()
}