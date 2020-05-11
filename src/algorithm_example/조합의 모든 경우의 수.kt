package src.algorithm_example

import java.util.*

// 200511
// 조합의 모든 경우의 수
// https://bumbums.tistory.com/2?category=728916

fun main() {
    val stack = Stack<String>()

    fun showStack() {
        for(i in stack) print("$i ")
        println()
    }

    fun doCombination(array: Array<String>, n: Int, r: Int, index: Int) {
        // r==0일 경우, 뽑을 것이 없으므로, stack에 쌓였던 값을 출력하고 return
        if(r == 0) {
            showStack()
            // 왜 여기에서 pop을 하지 않을까? -> 3컴비네이션0 같은 경우에서는 stack.pop() 할 수가 없기 때문
            return
        }
        // n==r일 경우, 남아있는 모든 것들을 스택에 넣어주고 showStack()
        if(n == r) {
            for (i in 0 until n) stack.push(array[index + i])
            showStack()
            for(i in 0 until n) stack.pop()
        } else {
            stack.push(array[index])
            doCombination(array, n-1, r-1, index + 1)

            // 위의 doCombination에서는 r==0으로 가는 상황까지 가면 끝난다.
            // 그 때 stack.pop()을 해주지 않으므로, 함수가 종료되면 해주는 것이다.
            stack.pop()

            // n==r인 상황에 도달하면 끝난다.
            doCombination(array, n-1, r, index + 1)
        }
    }

    // 메인 함수 실행
    val array = arrayOf("A", "B", "C", "D", "E")
    doCombination(array, 5, 3, 0)
}