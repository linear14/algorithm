package src.algorithm_beakjoon

import java.util.*

// 200501
// 2609 - 최대공약수와 최소공배수

// 최대공약수(GCD) 최소공배수(LCM)
// https://m.blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221133124302&proxyReferer=https:%2F%2Fwww.google.com%2F

// 최대공약수 구할 때, 굳이 숫자의 대소관계를 따지지 않아도 괜찮다.
// 만약 뒤에 있는 값이 크더라도, 계산과정에서 더 큰 숫자가 앞으로 이동하는 과정이 포함되기 때문이다.

fun main() {
    with(Scanner(System.`in`)) {
        var (a, b) = nextInt() to nextInt()
        val aMulB = a * b
        val gcd: Int

        if(a > b) {
            while(a % b != 0) {
                val temp = a % b
                a = b
                b = temp
            }
            gcd = b
        } else {
            while(b % a != 0) {
                val temp = b % a
                b = a
                a = temp
            }
            gcd = a
        }

        println(gcd)
        println(aMulB / gcd)
    }
}