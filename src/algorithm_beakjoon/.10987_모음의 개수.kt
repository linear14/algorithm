package algorithm_beakjoon

// 200412
// 10987 : 모음의 개수

fun main() {
    val input = readLine()!!
    var count = 0
    val list = arrayOf('a','e','i','o','u')
    for(i in input) {
        if(i in list) count++
    }
    print(count)
}