package self_boj

private fun main() {
    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()
        val picks = readLine()!!.split(" ").map { it.toInt() }
        val isVisited = BooleanArray(n + 1)
        val isDone = BooleanArray(n + 1)
        var ans = n

        fun dfs(now: Int) {
            isVisited[now] = true
            val next = picks[now - 1]

            if(!isVisited[next]) {
                dfs(next)
            }
            else if(!isDone[next]) {
                var i = next
                while(i != now) {
                    ans--
                    i = picks[i - 1]
                }
                ans--
            }
            isDone[now] = true
        }

        for(i in 1..n) {
            if(!isVisited[i]) {
                dfs(i)
            }
        }

        println(ans)
    }
}