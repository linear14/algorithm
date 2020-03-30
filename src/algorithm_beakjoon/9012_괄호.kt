package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200330
// 9012 - 괄호

/*

    stack 을 구현하여 '(' 혹은 ')' 이 입력 될 때 마다 쌓아 올리는 방식을 취함.
    이 때, VPS가 이루어지지 않는 조건을 2가지로 판단함
    1. ')' 가 들어올 때 '(' 가 존재하지 않으면 NO.
    - 즉 stack의 사이즈가 0이면 NO를 출력
    
    2. 모든 괄호를 스택에 넣었을 때 stack의 사이즈가 0이 아니면 NO
    - 남아있는 괄호가 있다는 뜻이므로

 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var t = br.readLine().toInt()
    a@while(t-- > 0) {
        val ps = br.readLine()
        val s = Stack<Char>()

        for(i in ps) {
            if(i == ')') {
                if(s.size == 0) {
                    bw.write("NO\n")
                    continue@a
                } else {
                    s.pop()
                }
            } else {
                s.push(i)
            }
        }

        if(s.size != 0) {
            bw.write("NO\n")
            continue
        }
        bw.write("YES\n")
    }
    bw.flush()
}
