package src.algorithm_beakjoon

// 200513
// 3046 - R2

fun main() {
    val (f, avg) = readLine()!!.split(" ").map { it.toInt() }
    print(2 * avg - f)
}