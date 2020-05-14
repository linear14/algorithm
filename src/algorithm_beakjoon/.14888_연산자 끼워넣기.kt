package src.algorithm_beakjoon

// 200512 ~ 200514
// 14888 - 연산자 끼워넣기

fun main() {
    val n = readLine()!!.toInt() // n = 6
    val numList = readLine()!!.split(" ").map{ it.toInt() }
    val signCount = readLine()!!.split(" ").map{ it.toInt() } as MutableList
    val signList = mutableListOf<Array<Int>>()

    fun isPossible(selected: Int): Boolean {
        if(signCount[selected] > 0) {
            signCount[selected]--
            return true
        }
        return false
    }
    // 0,1,2,3 각각 '+' '-' '*' '/' 부호에 해당
    val signExpressionArray = Array(n - 1) { 0 }
    fun backTracking(level: Int) {
        if(level == n - 1) {
            val newList = Array(n - 1 ){ 0 }
            for((index, item) in signExpressionArray.withIndex()) newList[index] = item
            signList.add(newList)
        } else {
            for(i in 0..3) {
                if(isPossible(i)) {
                    signExpressionArray[level] = i
                    backTracking(level + 1)
                    signCount[i]++  // 각 부호에 대한 처리가 끝났으면 부호를 다시 없애므로 signCount를 원래대로 돌려주는 작업
                }
            }
        }
    }

    backTracking(0)

    val answerList = mutableListOf<Int>()
    // 식을 모아놓은 리스트에서 한 개의 '식'을 꺼내온다. (가령 32001의 식은 '/ * + + -' 를 꺼내온 것이다)
    for(expression in signList) {
        var result = numList[0] // 첫 숫자
        for((index, sign) in expression.withIndex()) {
            when(sign) {
                0 -> result += numList[index + 1]
                1 -> result -= numList[index + 1]
                2 -> result *= numList[index + 1]
                3 -> if (result < 0) {
                    result *= (-1)
                    result /= numList[index + 1]
                    result *= (-1)
                } else {
                    result /= numList[index + 1]
                }
            }
        }
        answerList.add(result)
    }

    println(answerList.max())
    println(answerList.min())
}