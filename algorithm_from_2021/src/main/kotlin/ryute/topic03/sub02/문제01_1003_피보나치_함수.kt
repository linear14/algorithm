package ryute.topic03.sub02

private lateinit var memo: Array<Pair<Int ,Int>>

private fun main() {
    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()

        memo = Array(41) { Pair(0, 0) }
        memo[0] = Pair(1, 0)
        memo[1] = Pair(0, 1)

        val result = fibo(n)
        println("${result.first} ${result.second}")
    }
}

private fun fibo(n: Int): Pair<Int, Int> {
    if(n == 0) {
        return memo[0]
    }

    if(n == 1) {
        return memo[1]
    }

    if(memo[n] == Pair(0, 0)) {
        memo[n] = Pair(
                fibo(n-1).first + fibo(n-2).first,
                fibo(n-1).second + fibo(n-2).second
        )
    }
    return memo[n]
}

