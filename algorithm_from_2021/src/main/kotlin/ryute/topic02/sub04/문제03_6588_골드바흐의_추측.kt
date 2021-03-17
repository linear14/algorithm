package ryute.topic02.sub04

private fun main() {

    val primeList = makePrimeArray()

    while(true) {
        val n = readLine()!!.toInt()
        if(n == 0) break

        var isHaveAns = false

        for(i in 3 until primeList.size) {
            val a = i
            val b = n - a
            if (primeList[a] && primeList[b]) {
                println("$n = $a + $b")
                isHaveAns = true
                break
            }
        }

        if(!isHaveAns) {
            println("Goldbach's conjecture is wrong.")
        }
    }
}

private fun makePrimeArray(): Array<Boolean> {

    val arr = Array(1000001) { true }
    arr[0] = false
    arr[1] = false

    for(i in 2 until 1000001) {
        var num = i * 2

        while(num <= 1000000) {
            if(arr[num]) {
                arr[num] = false
            }

            num += i
        }
    }

    return arr
}