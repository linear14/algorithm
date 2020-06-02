package src.algorithm_beakjoon

// 200602
// 1912 - 연속합

// https://mygumi.tistory.com/97 참고

fun main() {
    val n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()

    var max = array[0]
    for(i in 1 until array.size) {
        if(array[i - 1] >= 0) {
            array[i] += array[i - 1]
        }

        if(max < array[i]) max = array[i]
    }
    println(max)
}