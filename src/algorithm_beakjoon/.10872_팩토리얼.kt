package algorithm_beakjoon

// 200415
// 10872 - 팩토리얼

fun main() {
    fun factorial(n: Int): Int {
        var ans = n
        if(n == 0 || n == 1) return 1
        return ans * factorial(n - 1)
    }

    val n = readLine()!!.toInt()
    print(factorial(n))
}