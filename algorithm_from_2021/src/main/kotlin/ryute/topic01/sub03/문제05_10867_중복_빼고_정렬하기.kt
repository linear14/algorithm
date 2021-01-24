package ryute.topic01.sub03

private fun main() {
    solution03()
}

private fun solution01() {
    readLine()
    val set = readLine()!!.split(" ").toHashSet()

    set.toMutableList().sorted().forEach { print("$it ") }
}

/*** 정답 코드 ***/
private fun solution02() {
    readLine()
    val set = readLine()!!.split(" ").map { it.toInt() }.toHashSet()

    set.toMutableList().sorted().forEach { print("$it ") }
}

// Set에서 바로 sort가 가능한지는 처음 알았음
/*** 정답 코드 ***/
private fun solution03() {
    readLine()
    readLine()!!.split(" ")
            .map { it.toInt() }
            .toSet()
            .sorted()
            .forEach { print("$it ")}
}