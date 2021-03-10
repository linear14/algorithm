package ryute.topic02.sub04

private fun main() {
    val prime = makePrimeArray()
    val n = readLine()!!.toInt()

    var start = 0
    var end = 0
    var ans = 0

    while(end < prime.size && prime[end] <= n) {
        var sum = 0
        for(i in start .. end) {
            sum += prime[i]
        }
        when(sum) {
            in 0 until n -> end++
            n -> {
                ans++
                end++
            }
            else -> start++
        }
    }
    println(ans)
}

private fun makePrimeArray(): MutableList<Int> {
    val arr = Array(4000001) { true }
    arr[0] = false
    arr[1] = false

    for(i in 2 until 4000001) {
        var index = i * 2
        while(index < 4000001) {
            if(arr[index]) {
                arr[index] = false
            }
            index += i
        }
    }

    val primeList = mutableListOf<Int>()
    for(i in 0 until 4000001) {
        if(arr[i]) {
            primeList.add(i)
        }
    }
    return primeList
}