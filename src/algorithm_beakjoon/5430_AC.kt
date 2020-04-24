package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200424
// 5430 - AC

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var t = br.readLine().toInt()
    val builder = StringBuilder()

    a@while(t-- > 0) {
        val command = br.readLine()
        val n = br.readLine().toInt()
        if(n == 0) {
            br.readLine()
            if(command.contains("D")) {
                builder.append("error\n")
            } else {
                builder.append("[]\n")
            }
            continue@a
        }
        val inputs = br.readLine()
        val input = inputs.substring(1, inputs.length - 1).split(",")

        val listForward = ArrayList<String>()
        for(i in input) listForward.add(i)
        var isForward = true

        for(i in command) {
            when(i) {
                'R' -> isForward = !isForward

                'D' -> {
                    if(listForward.isEmpty()) {
                        builder.append("error\n")
                        continue@a
                    }

                    if(isForward) {
                        listForward.removeAt(0)
                    } else {
                        listForward.removeAt(listForward.size - 1)
                    }

                }
            }
        }

        builder.append("[")
        if(listForward.isEmpty()) builder.append("]\n")
        else {
            if(!isForward) listForward.reverse()
            val lastIndex = listForward.size - 1
            for (i in listForward.indices) {
                builder.append(listForward[i])
                if (i != lastIndex) builder.append(",")
                else builder.append("]\n")
            }
        }
    }

    bw.write(builder.toString())
    bw.flush()
}

// 고수분의 답
/*


fun main(args:Array<String>) {
    for (i in 0 until readLine()!!.toInt()) {
        val func = readLine()!!
        val n = readLine()!!.toInt()
        val array = LinkedList(readLine()!!.trim{ it=='[' || it == ']' }.split(","))
        var first = true
        var ok = true
        for (it in func) {
            if (it == 'R') {
                first = !first
            }
            else {
                if (array.size == 0 || array[0] == "") {
                    ok = false
                    break
                }
                else if (first) {array.removeFirst()}
                else {array.removeLast()}
            }
        }
        if (ok) {println((if (first) array else array.reversed()).joinToString(prefix="[", postfix = "]", separator = ","))}
        else {println("error")}
    }
}

*/
