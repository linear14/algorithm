package src.algorithm_beakjoon

// 200515
// 1003 - 피보나치 함수

fun main() {
    val t = readLine()!!.toInt()
    val fiboArray = Array(41){ Pair(0, 0) }

    fiboArray[0] = Pair(1, 0)
    fiboArray[1] = Pair(0, 1)

    for(i in 2..40) {
        fiboArray[i] = Pair(fiboArray[i - 1].first + fiboArray[i - 2].first,
            fiboArray[i - 1].second + fiboArray[i - 2].second)
    }

    repeat(t) {
        val n = readLine()!!.toInt()
        println("${fiboArray[n].first} ${fiboArray[n].second}")
    }
}