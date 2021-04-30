package ryute.topic04.sub01

private fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val list = IntArray(n) { readLine()!!.toInt() }
    var ans = 0

    for(i in n-1 downTo 0) {
        val cnt = k / list[i]
        ans += cnt
        k -= cnt * list[i]
    }

    println(ans)
}