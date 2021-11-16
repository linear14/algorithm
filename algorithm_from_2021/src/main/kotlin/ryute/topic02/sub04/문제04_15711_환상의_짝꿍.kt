package ryute.topic02.sub04

import sun.security.ec.point.ProjectivePoint
import kotlin.math.sqrt

/***
    1) 2가 아닌 짝수는 소수가 아니다.
    2) 판별하려는 수(n이라고 하자.)의 제곱근을 구한다. 이것을 s라고 하자.
    3) s가 정수이면 n은 완전제곱수이므로 소수가 아니다.
    4) s가 정수가 아니라면 s보다 작은 모든 소수로 n을 차례대로 나눈다.
    5) 도중에 나누어 떨어지는 수가 있다면 n은 소수가 아니다. 나누어 떨어지는 수가 없다면 n은 소수이다.
 ***/


private fun main() {
    val t = readLine()!!.toInt()

    loop@for(i in 0 until t) {
        val (a, b) = readLine()!!.split(" ").map { it.toLong() }
        val sum = a + b
        val sqrt = sqrt(sum.toDouble()).toLong()

        if(sqrt * sqrt == sum) {
            println("NO")
            continue@loop
        }

        val primeList = makePrime(sqrt.toInt())

        for(prime in primeList) {
            if(sum % prime == 0L) {
                println("NO")
                continue@loop
            }
        }
        println("YES")
    }
}

private fun makePrime(max: Int): MutableList<Int> {
    val prime = Array(max + 1) { true }
    prime[0] = false
    prime[1] = false

    for(i in 2..max) {
        var target = i * 2
        while(target <= max) {
            if(prime[target]) {
                prime[target] = false
            }
            target += i
        }
    }

    val newPrimeList = mutableListOf<Int>()
    for(i in prime.indices) {
        if(prime[i]) {
            newPrimeList.add(i)
        }
    }
    return newPrimeList
}