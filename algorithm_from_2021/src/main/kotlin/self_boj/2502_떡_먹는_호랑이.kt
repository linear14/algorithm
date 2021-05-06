package self_boj

private fun main() {
    val (d, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(d) { Pair(0, 0) }
    arr[0] = Pair(1, 0)
    arr[1] = Pair(0, 1)

    for(i in 2 until d) {
        arr[i] = Pair(arr[i-1].first + arr[i-2].first, arr[i-1].second + arr[i-2].second)
    }

    val x = arr[d-1].first
    val y = arr[d-1].second

    var a = 0
    var b = 1
    while(true) {
        val target = k - y * b
        if(target % x == 0 && target / x <= b) {
            a = target / x
            break
        } else {
            b++
        }
    }

    println(a)
    println(b)
}