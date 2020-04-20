package src.algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200420
// 11866 - 요세푸스 문제 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine().split(" ")
    val (n, k) = input[0].toInt() to input[1].toInt()

    val list1 = LinkedList<Int>()
    val list2 = LinkedList<Int>()
    val builder = StringBuilder()
    val removedList = mutableListOf<Int>()
    var whereRemove = 1

    for(i in 1..n) list1.add(i)

    while(removedList.size < n) {
        a@for(count in 1..k) {
            when(whereRemove){
                1 -> {
                    val temp = list1.poll()
                    if(count == k) {
                        removedList.add(temp)
                    } else list2.add(temp)
                    if(list1.isEmpty()) whereRemove = 2
                }

                2 -> {
                    val temp = list2.poll()
                    if(count == k) {
                        removedList.add(temp)
                    } else list1.add(temp)
                    if(list2.isEmpty()) whereRemove = 1

                }
            }
        }
    }

    builder.append("<")
    for(i in removedList.indices) {
        builder.append(removedList[i])
        if(i != removedList.size - 1) {
            builder.append(", ")
        }
    }
    builder.append(">")

    bw.write(builder.toString())
    bw.flush()
}