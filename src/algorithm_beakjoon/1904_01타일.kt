package src.algorithm_beakjoon

// 200518
// 1904 - 01타일
// http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787441430

fun main() {
    val n = readLine()!!.toInt()
    val answer = Array(n + 1){ 0 }
    answer[1] = 1
    if(n >= 2) answer[2] = 2

    for (i in 3..n) {
        answer[i] = (answer[i - 2] % 15746 + answer[i - 1] % 15746) % 15746
    }

    print(answer[n])
}