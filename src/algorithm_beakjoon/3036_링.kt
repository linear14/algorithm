package src.algorithm_beakjoon

// 200503
// 3036 - 링

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val first = sc.nextInt()

    repeat(n - 1) {
        var a = first
        var b = sc.nextInt()

        val (originalA, originalB) = a to b

        while(a % b != 0) {
            val temp = a % b
            a = b
            b = temp
        }

        println("${originalA / b}/${originalB / b}")
    }
}
