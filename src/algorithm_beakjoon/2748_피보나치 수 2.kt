package src.algorithm_beakjoon

// 200515
// 2748 - 피보나치 수 2

fun main() {
    val n = readLine()!!.toInt()
    val fiboList = LongArray(n + 1)
    fiboList[0] = 0
    fiboList[1] = 1

    for(i in 2..n) {
        fiboList[i] = fiboList[i - 1] + fiboList[i - 2]
    }

    print(fiboList[n])
}