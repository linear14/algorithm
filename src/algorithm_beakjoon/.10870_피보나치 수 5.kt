package algorithm_beakjoon

// 200415
// 10870 - 피보나치 수 5

fun main() {
    fun fibo(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1
        return fibo(n - 1) + fibo(n - 2)
    }

    val n = readLine()!!.toInt()
    print(fibo(n))
}