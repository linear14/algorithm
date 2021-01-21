package ryute.topic01.sub03

private fun main() {
    solution01()
}

/*
    단순히 결과의 최소값만을 구하는 문제이기 때문에
    하나는 오름차순, 하나는 내림차순해서 인덱스 순서대로 서로 곱한값을 더하기만 했음
 */
/*** 정답 코드 ***/
private fun solution01() {
    val n = readLine()!!.toInt()
    val listA = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val listB = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    var sum = 0

    repeat(n) {
        sum += (listA[it] * listB[it])
    }

    println(sum)
}