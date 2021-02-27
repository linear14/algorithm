package ryute.topic02.sub02

private fun main() {
    val prime = Array(1001) { i -> i }

    for(i in prime.indices) {
        if(i == 0 || i == 1) {
            prime[i] = 0
            continue
        }

        if(prime[i] == 0) {
            continue
        }

        var next = i
        while(next <= 1000) {
            if(next != i) {
                prime[next] = 0
            }
            next += i
        }
    }

    var ans = 0
    val n = readLine()!!.toInt()
    val candidate = readLine()!!.split(" ").map { it.toInt() }
    candidate.forEach {
        if(prime[it] != 0) {
            ans++
        }
    }
    println(ans)
}