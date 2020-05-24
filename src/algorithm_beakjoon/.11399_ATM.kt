package src.algorithm_beakjoon

// 200524
// 11399 - ATM

fun main() {
    var n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()
    array.sort()

    var sum = 0
    for(value in array) {
        sum += ((n--) * value)
    }

    print(sum)
}