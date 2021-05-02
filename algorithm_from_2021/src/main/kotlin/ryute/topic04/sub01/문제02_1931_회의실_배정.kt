package ryute.topic04.sub01

private fun main() {
    val n = readLine()!!.toInt()
    val table = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    table.sortBy { it[0] }
    table.sortBy { it[1] }

    var ans = 0
    var lastTime = 0

    for(time in table) {
        val (start, end) = time[0] to time[1]
        // println("$start $end")
        if(start >= lastTime) {
            ans++
            lastTime = end
        }
    }

    print(ans)
}