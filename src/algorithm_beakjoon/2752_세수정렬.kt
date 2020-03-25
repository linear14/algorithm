package algorithm_beakjoon

import java.util.*

// 200325
// 2752 : 세수정렬

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val array = Array(3) {i -> sc.nextInt()}
    var index: Int? = null

    for(i in array.indices) {
        var min = 1000001
        for(j in i until 3) {
            if(min > array[j]) {
                min = array[j]
                index = j
            }
        }
        val temp = array[i]
        array[i] = array[index!!]
        array[index] = temp
    }

    for(i in array) {
        print("$i ")
    }
}
