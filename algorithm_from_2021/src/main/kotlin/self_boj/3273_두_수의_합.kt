package self_boj

private fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray().also {
        it.sort()
    }
    val x = readLine()!!.toInt()

    var ans = 0

    for(a in arr) {
        val b = x - a
        if(b in arr) {
            ans++
        }
    }

    print(ans / 2)
}