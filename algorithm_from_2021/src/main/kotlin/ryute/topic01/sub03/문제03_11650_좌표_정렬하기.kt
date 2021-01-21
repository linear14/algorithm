package ryute.topic01.sub03

private fun main() {
    solution01()
}

// 변수 없이도 만들어지네.. ㅎㅎ
// 시간 엄청 아슬아슬하니 입출력 스트림 사용하자
/*** 정답 코드 ***/
private fun solution01() {
    Array(readLine()!!.toInt()) {
        val item = readLine()!!.split(" ").map { it.toInt() }
        Pair(item[0], item[1])
    }.apply {
        sortWith { d1, d2 ->
            if(d1.first == d2.first) {
                d1.second - d2.second
            } else {
                d1.first - d2.first
            }
        }
    }.forEach { println("${it.first} ${it.second}") }
}