package src.algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

// 200501 (끝낸 날.. 5일 동안 답을 못 찾아서 결국 블로그에서 힌트 글 찾아서 해결)
// 11729 - 하노이 탑 이동 순서

// https://shoark7.github.io/programming/algorithm/tower-of-hanoi
// 재귀 문제를 풀기전에는 작은 경우로 최대한 쪼개서 생각해보기.
// 설계를 무조건적으로 하는 연습을 하자.
// 위의 블로그 글은 설명도 잘 되어있을 뿐 아니라, 문제에 대한 올바른 접근 방법을 알기 쉽게 설명 한 글이기 때문에
// 한 번 꼭 다시 읽어봤으면 싶다.

fun main() {
    with(StringBuilder()) {
        val sc = Scanner(System.`in`)
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = sc.nextInt()
        var count = 0

        fun hanoi(n: Int, start: Int, to: Int, via: Int) {
            count++
            if(n == 1) {
                append("$start $to\n")
                return
            }

            hanoi(n - 1, start, via, to)
            append("$start $to\n")
            hanoi(n - 1, via, to, start)
        }

        hanoi(n,1, 3, 2)
        bw.write("${count}\n")
        bw.write(toString())
        bw.flush()
    }
}



/*

처음에 접근했던 요상한 방법!

fun main() {
    with(StringBuilder()) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        fun moveBlock(startHeight: Int, startPosition: Int, targetPosition: Int, movingNum: Int) {
            if(startHeight == 0 || movingNum > startHeight) return
            */
/*
                    시작 height가 홀수인 경우
                    movingNum가 홀수이면 targetPosition을 멀리 두기
                    movingNum가 짝수이면 targetPosition을 가깝게 두기
                    시작 height가 짝수인 경우
                    movingNum가 홀수이면 targetPosition을 가깝게 두기
                    movingNum가 짝수이면 targetPosition을 멀리 두기
            *//*

            var num = movingNum
            while(num <= startHeight) {
                if (startHeight % 2 == 1) {
                    if (movingNum % 2 == 1) {
                        append("$startPosition ${if(startPosition == 1) 3 else startPosition - 1}\n")
                        moveBlock(
                            movingNum - 1,
                            if(startPosition == 3) 1 else startPosition + 1,
                            if(startPosition == 1) 3 else startPosition - 1,
                            1
                        )
                    } else {
                        append("$startPosition ${if(startPosition == 3) 1 else startPosition + 1}\n")
                        moveBlock(
                            movingNum - 1,
                            if(startPosition == 1) 3 else startPosition - 1,
                            if(startPosition == 3) 1 else startPosition + 1,
                            1
                        )
                    }
                } else {
                    if (movingNum % 2 == 1) {
                        append("$startPosition ${if (startPosition == 3) 1 else startPosition + 1}\n")
                        moveBlock(
                            movingNum - 1,
                            if (startPosition == 1) 3 else startPosition - 1,
                            if (startPosition == 3) 1 else startPosition + 1,
                            1
                        )
                    } else {
                        append("$startPosition ${if (startPosition == 1) 3 else startPosition - 1}\n")
                        moveBlock(
                            movingNum - 1,
                            if (startPosition == 3) 1 else startPosition + 1,
                            if (startPosition == 1) 3 else startPosition - 1,
                            1
                        )
                    }
                }
                num++
                moveBlock(startHeight, startPosition, targetPosition, movingNum + 1)
            }
        }
        moveBlock(n, 1, 3, 1)
        bw.write(toString())
        bw.flush()
    }


}

*/
