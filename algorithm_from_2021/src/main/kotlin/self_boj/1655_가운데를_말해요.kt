package self_boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun main() {
    val n = readLine()!!.toInt()
    val sb = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val spq = PriorityQueue<Int> { a, b -> b - a }
    val lpq = PriorityQueue<Int> { a, b -> a - b }

    var current = 0

    repeat(n) {
        val target = readLine()!!.toInt()
        if(it == 0) {
            current = target
        }
        else {
            if(current <= target) {
                if(spq.size < lpq.size) {
                    lpq.add(target)
                    spq.add(current)
                    current = lpq.poll()
                }
                else {
                    lpq.add(target)
                }
            }
            else {
                if(spq.size >= lpq.size) {
                    spq.add(target)
                    lpq.add(current)
                    current = spq.poll()
                }
                else {
                    spq.add(target)
                }
            }
        }

        sb.append("${current}\n")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}