package src.algorithm_beakjoon

// 200522
// 10844 - 쉬운 계단 수

fun main() {
    val n = readLine()!!.toInt()
    val array = Array(10){ Array(n + 1){ 0 } }
    array[0][1] = 0
    for(i in 1..9) array[i][1] = 1

    for(level in 2..n) {
        array[0][level] = array[1][level - 1] % 1000000000
        for(i in 1..8) array[i][level] = (array[i - 1][level - 1] % 1000000000 + array[i + 1][level - 1] % 1000000000) % 1000000000
        array[9][level] = array[8][level - 1] % 1000000000
    }

    var sum = 0
    for(i in 0..9) sum = (sum + (array[i][n] % 1000000000)) % 1000000000
    print(sum % 1000000000)
}
