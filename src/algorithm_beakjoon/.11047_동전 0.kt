package src.algorithm_beakjoon

// 200522
// 11047 - 동전 0

fun main() {
    var (n, k) = readLine()!!.split(" ").map{ it.toInt() }
    val list = Array(n){ readLine()!!.toInt() }

    var ans = 0
    for(index in list.size-1 downTo 0) {
        while(k % list[index] != k && k != 0) {
            ans++
            k -= list[index]
        }
    }
    print(ans)
}
