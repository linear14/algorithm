package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 200330
// 4949 - 균형잡힌 세상

/*
        9012 문제의 응용
        (를 담는 stack, [를 담는 stack 총 2개를 만들어서 관리
        방향은 이전 문제와 같지만,
        추가적으로 고려 해야 할 부분은 ( 와 [ 가 stack에 들어갈 때의 인덱스가 어떻게 될까? 이 부분이었다.

        예를 들어, ([)] 와 같은 경우 이전 문제의 경우로 풀면 yes지만 원하는 답은 no이다.
        따라서, 마지막으로 ( 혹은 [ 가 stack에 들어갈 때의 index를 관리하는 list를 만들어서

        ) 가 입력될 때 마지막으로 ( 가 들어간 인덱스보다 [ 가 들어간 인덱스 값이 크다면 no를 출력하도록 설정했다.
        정상적으로 )가 들어간다면, stack에 들어갔던 (가 올바르게 지워진 것이므로, ( 의 인덱스를 관리하는 list의 마지막 값을 삭제하면서 진행했다.

 */

var str =""
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLines()
    val list = mutableListOf<String>()

    for(i in input){
        for(char in i) {
            if(char == '(' || char == ')' || char == '[' || char == ']' || char == '.') {
                makeStrArray(char, list)
            }
        }
    }

    a@for(i in 0 until list.size - 1) {
        var sSmall = Stack<Char>()
        var sLarge = Stack<Char>()

        var inputIndexSmallList = mutableListOf<Int>()
        var inputIndexLargeList = mutableListOf<Int>()
        inputIndexSmallList.add(-2)
        inputIndexLargeList.add(-2)

        val selectedString = list[i]
        for(charIndex in selectedString.indices) {
            var char = selectedString[charIndex]
            if(char == ')') {
                if(sSmall.isEmpty()) {
                    bw.write("no\n")
                    continue@a
                } else {
                    if(inputIndexSmallList[inputIndexSmallList.size - 1] <
                        inputIndexLargeList[inputIndexLargeList.size - 1]) {
                        bw.write("no\n")
                        continue@a
                    }
                    sSmall.pop()
                    inputIndexSmallList.removeAt(inputIndexSmallList.size - 1)
                }
            } else if(char == ']') {
                if(sLarge.isEmpty()) {
                    bw.write("no\n")
                    continue@a
                } else {
                    if(inputIndexSmallList[inputIndexSmallList.size - 1] >
                        inputIndexLargeList[inputIndexLargeList.size - 1]) {
                        bw.write("no\n")
                        continue@a
                    }
                    sLarge.pop()
                    inputIndexLargeList.removeAt(inputIndexLargeList.size - 1)
                }
            } else {
                when(char) {
                    '(' -> {
                        sSmall.push('(')
                        inputIndexSmallList.add(charIndex)
                    }
                    '[' -> {
                        inputIndexLargeList.add(charIndex)
                        sLarge.push('[')
                    }

                }
            }
        }

        if(sSmall.isNotEmpty() || sLarge.isNotEmpty()) {
            bw.write("no\n")
        } else {
            bw.write("yes\n")
        }
    }

    bw.flush()
}

fun makeStrArray(char: Char, list: MutableList<String>) {
    if(char == '.') {
        list.add(str)
        str = ""
    } else {
        str += char
    }
}
