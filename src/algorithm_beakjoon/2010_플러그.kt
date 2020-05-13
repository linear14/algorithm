package src.algorithm_beakjoon

// 200513
// 2010 - 플러그

fun main() {
    val n = readLine()!!.toInt()
    var ans = 1
    repeat(n) {
        ans--
        ans += readLine()!!.toInt()
    }
    print(ans)
}