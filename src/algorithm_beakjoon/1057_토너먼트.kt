package src.algorithm_beakjoon

// 200615
// 1057 - 토너먼트

fun main() {
    val info = readLine()!!.split(" ").map{ it.toInt() }
    val n = info[0]
    val ab = arrayOf(info[1], info[2])
    ab.sort()

    fun verify(remain: Int, round: Int) {
        if(ab[0] % 2 == 1 && ab[0] + 1 == ab[1] || remain == 2) {
            print(round)
        } else {
            ab[0] = (ab[0] + 1) / 2
            ab[1] = (ab[1] + 1) / 2
            verify(if (remain % 2 == 0) remain / 2 else (remain / 2 + 1), round + 1)
        }
    }

    if(n == 1) print(-1) else verify(n, 1)
}