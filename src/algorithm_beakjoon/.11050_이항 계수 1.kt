package src.algorithm_beakjoon

// 200513
// 11050 - 이항 계수 1

fun main() {
    val (n, k) = readLine()!!.split(" ").map{ it.toInt() }

    if(k == 0 || k == n) {
        print(1)
    } else {
        var top = 1
        var bottom = 1
        for(i in n - k + 1 .. n) top *= i
        for(i in 1 .. k) bottom *= i
        print(top / bottom)
    }
}

/*

이런 방법도 있음 (재귀를 이용)


fun bino(n: Int, k: Int): Int {
    if (n == k || k == 0) return 1
    return bino(n-1, k) + bino(n-1, k-1)
}

fun main() = with(Scanner(System.`in`)) {
    var n = nextInt()
    var k = nextInt()
    println(bino(n, k))
}

*/
