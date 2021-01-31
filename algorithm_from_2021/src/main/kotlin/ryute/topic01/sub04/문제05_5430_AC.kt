package ryute.topic01.sub04

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

private fun main() {
    solution02()
}

/*** 정답 코드 ***/
private fun solution01() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()

    repeat(t) {
        val sb = StringBuilder().apply {
            append("[")
        }

        val commands = readLine()!!
        val n = readLine()!!.toInt()

        val array = readLine()!!
        val nums = if(n == 0) {
            mutableListOf()
        } else {
            array.substring(1, array.length - 1).split(",").map { it.toInt() }.toMutableList()
        }

        var isReversed = false
        var isError = false

        for(command in commands) {
            when(command) {
                'R' -> {
                    isReversed = !isReversed
                }
                'D' -> {
                    if(nums.isNullOrEmpty()) {
                        isError = true
                        break
                    }
                    if(!isReversed) {
                        nums.removeAt(0)
                    } else {
                        nums.removeAt(nums.size - 1)
                    }
                }
            }
        }

        if(!isReversed) {
            for(i in 0 until nums.size) {
                sb.append(nums[i])

                if(i != nums.size - 1) {
                    sb.append(",")
                }
            }
        } else {
            for(i in nums.size - 1 downTo 0) {
                sb.append(nums[i])

                if(i != 0) {
                    sb.append(",")
                }
            }
        }

        sb.append("]")

        if(isError) {
            bw.write("error\n")
        } else {
            bw.write("${sb}\n")
        }
    }
    bw.flush()
    bw.close()
}


// 자료구조를 LinkedList로 변경하여 하니깐 시간 단축 엄청나게 많이됨
// StringTokenizer를 사용해봤음 (살면서 처음)
/*** 정답 코드 ***/
private fun solution02() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()

    repeat(t) {
        var isReversed = false
        var isError = false

        val sb = StringBuilder().apply {
            append("[")
        }

        val commands = readLine()!!
        val n = readLine()!!.toInt()
        val st = StringTokenizer(readLine()!!, "[],")

        val deque = LinkedList<String>()
        while(st.hasMoreTokens()) {
            deque.add(st.nextToken())
        }

        for(command in commands) {
            when(command) {
                'R' -> {
                    isReversed = !isReversed
                }
                'D' -> {
                    if(deque.isNullOrEmpty()) {
                        isError = true
                        break
                    }
                    if(!isReversed) {
                        deque.pollFirst()
                    } else {
                        deque.pollLast()
                    }
                }
            }
        }

        val dequeSize = deque.size

        for(i in 0 until dequeSize) {
            if(!isReversed) {
                sb.append(deque.pollFirst())
            } else {
                sb.append(deque.pollLast())
            }

            if(i != dequeSize - 1) {
                sb.append(",")
            }
        }

        sb.append("]")

        if(isError) {
            bw.write("error\n")
        } else {
            bw.write("${sb}\n")
        }
    }

    bw.flush()
    bw.close()
}