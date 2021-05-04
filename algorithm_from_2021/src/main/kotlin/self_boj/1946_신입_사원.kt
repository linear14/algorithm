package self_boj

private fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val scoreList = Array(n) { readLine()!!.split(" ").map{ it.toInt() } }
        scoreList.sortBy { it[0] }

        var min = Integer.MAX_VALUE

        var ans = 0
        for(score in scoreList) {
            if(min > score[1]) {
                min = score[1]
                ans++
            }
        }

        println(ans)
    }
}