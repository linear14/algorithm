package ryute.topic01.sub01

import kotlin.math.pow

private fun main() {
    solution02()
}

// 시간초과
// 요소 하나하나가 리스트 전체를 돌면서 값이 존재하는지 아닌지를 찾는 방식
// 예상 시간복잡도 O(N^2)
private fun solution01() {
    readLine()!!
    val list = readLine()!!.split(" ").map{ it.toInt() }
    readLine()!!

    readLine()!!
        .split(" ")
        .map { it.toInt() }
        .forEach {
            if(it in list) {
                println(1)
            } else {
                println(0)
            }
        }
}

/*** 정답 코드 ***/
// 이진탐색을 이용하여 작업 (list 정렬 후 이진탐색)
private fun solution02() {
    readLine()!!
    val orderedList = readLine()!!.split(" ").map{ it.toInt() }.sorted()
    readLine()!!

    val targets = readLine()!!.split(" ").map{ it.toInt() }.forEach { target ->
        var start = 0
        var end = orderedList.size - 1

        while(start <= end) {
            val middle = (start + end) / 2

            when {
                target == orderedList[middle] -> {
                    println(1)
                    return@forEach
                }
                target < orderedList[middle] -> { end = middle - 1 }
                target > orderedList[middle] -> { start = middle + 1 }
            }
        }
        println(0)
    }

}


private fun makeStringTest(): String {
    val builder = StringBuilder()

    for(i in 1000000 downTo 1) {
        builder.append(i)
        if(i != 1) {
            builder.append(" ")
        }
    }

    return builder.toString()
}

private fun solution02Test(string: String, list: String) {
    val start = System.nanoTime()

    val orderedList = string.split(" ").map{ it.toInt() }.sorted()

    val targets = list.split(" ").map{ it.toInt() }.forEach { target ->
        var start = 0
        var end = orderedList.size - 1

        while(start <= end) {
            val middle = (start + end) / 2

            when {
                target == orderedList[middle] -> {
                    println(1)
                    return@forEach
                }
                target < orderedList[middle] -> { end = middle - 1 }
                target > orderedList[middle] -> { start = middle + 1 }
            }
        }
        println(0)
    }

    val end = System.nanoTime()

    println("${(end - start) * 10.0.pow(-9.0)}초")
}