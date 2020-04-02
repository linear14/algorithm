package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200330
// 10828 - 스택

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    val s = Stack<Int>()
    var sCommand = List(2){""}

    while(n-- > 0) {
        sCommand = br.readLine().split(" ")
        when(sCommand[0]) {
            "push" -> s.push(sCommand[1].toInt())
            "pop" -> {
                if(s.isEmpty()) bw.write("-1\n")
                else bw.write("${s.pop()}\n")
            }
            "size" -> bw.write("${s.size}\n")
            "empty" -> {
                if(s.isEmpty()) bw.write("1\n")
                else bw.write("0\n")
            }
            "top" -> {
                if(s.isEmpty()) bw.write("-1\n")
                else bw.write("${s.peek()}\n")
            }
        }
    }
    bw.flush()
}
