package src.algorithm_beakjoon

import java.lang.StringBuilder

fun main() {
    with(StringBuilder()) {
        readLine()!!.map{ append(if(it <= 'C') it+('X'-'A') else it-3) }
        print(toString())
    }
}