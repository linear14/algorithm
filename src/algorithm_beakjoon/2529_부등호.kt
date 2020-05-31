package src.algorithm_beakjoon

// 200531
// 2529 - 부등호

fun main() {
    val k = readLine()!!.toInt()
    val signList = readLine()!!.split(" ")
    val array = Array(k + 1){ 0 }

    var min: String? = null
    var max: String? = null

    fun isPossible(level: Int): Boolean {
        if(level == 0) return true

        // 중복되는 수 처리
        for(i in 0 until level) if(array[level] == array[i]) return false

        // 직전수와의 관계 처리
        when(signList[level - 1]) {
            "<" -> if(array[level - 1] > array[level]) return false
            ">" -> if(array[level - 1] < array[level]) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == k + 1) {
            val builder = StringBuilder()
            for(i in array) builder.append(i)
            val newNum = builder.toString()

            if(min == null) {
                min = newNum
                max = newNum
            } else {
                if(min!! > newNum) min = newNum
                if(max!! < newNum) max = newNum
            }
        } else {
            for(i in 0..9) {
                array[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    println(max)
    println(min)

}