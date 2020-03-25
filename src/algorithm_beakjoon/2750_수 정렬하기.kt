package algorithm_beakjoon

// 200325
// 2750 : 수 정렬하기

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var list = Array(n) {0}
    for(i in 0 until n){
        list[i] = sc.nextInt()
    }

    sort(list, 0, n - 1)

    for(i in list) {
        println("$i")
    }

}

fun sort(list: Array<Int>, startIndex: Int, endIndex: Int) {
    if(startIndex >= endIndex) {
        return
    }

    var pivot = startIndex
    var biggerThanPivot = startIndex + 1
    var smallerThanPivot = endIndex

    while(biggerThanPivot <= smallerThanPivot) {
        while(biggerThanPivot <= endIndex && list[biggerThanPivot] <= list[pivot]) {
            biggerThanPivot++
        }
        while(smallerThanPivot >= startIndex && list[smallerThanPivot] > list[pivot]) {
            smallerThanPivot--
        }

        if(biggerThanPivot <= smallerThanPivot) {
            val temp = list[biggerThanPivot]
            list[biggerThanPivot] = list[smallerThanPivot]
            list[smallerThanPivot] = temp
        } else {
            val temp = list[smallerThanPivot]
            list[smallerThanPivot] = list[pivot]
            list[pivot] = temp
        }
    }

    sort(list, startIndex, smallerThanPivot - 1)
    sort(list, smallerThanPivot + 1, endIndex)
}