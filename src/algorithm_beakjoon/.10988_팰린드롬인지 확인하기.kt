package src.algorithm_beakjoon

// 200506
// 10988 - 팰린드롬인지 확인하기

fun main() {
    val input = readLine()!!
    val size = input.length
    var ans = 1
    for((index, word) in input.withIndex()) {
        if(index >= (size + 1 / 2)) break
        if(word != input[size - (index + 1)]) {
            ans = 0
            break
        }
    }
    print(ans)
}