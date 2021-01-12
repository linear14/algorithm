package ryute.topic01.sub01

private fun main() {
    solution01()
}

/*** 정답 코드 ***/
// 간단하게 sort함수 사용해서 했지만, 여러 정렬법에 대한 코드를 스스로 작성해봐야한다.
private fun solution01() {
    val list = mutableListOf<Int>()

    val n = readLine()!!.toInt()
    repeat(n) {
        list.add(readLine()!!.toInt())
    }

    list.sort()
    list.forEach { println(it) }
}