package self_boj

private fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val list = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0

    var start = 0
    var end = 0

    while(true) {
        if(start > n || end > n) {
            break
        }

        var sum = 0

        for(i in start until end) {
            sum += list[i]
        }

        if(sum == s) {
            /*print("$start - $end")
            println()*/
            ans++
        }

        if(sum > s || end == n) {
            start++
            continue
        }
        end++
    }
    print(ans)
}
