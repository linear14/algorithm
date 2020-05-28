package src.algorithm_beakjoon

// 200528
// 1759 - 암호 만들기

fun main() {
    val builder = StringBuilder()
    val (l, c) = readLine()!!.split(" ").map{ it.toInt() }
    val word = readLine()!!.split(" ").map{ it.single() }.toCharArray()
    word.sort()

    val ans = Array(l){ 'a'-1 }
    val vowelList = mutableListOf('a','e','i','o','u')

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(ans[level] <= ans[i]) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == l) {
            var countVowel = 0
            var countConsonant = 0
            for(i in ans) {
                if(i in vowelList) countVowel++
                else countConsonant++
            }

            if(countVowel >= 1 && countConsonant >= 2) {
                for(i in ans) {
                    builder.append("$i")
                }
                builder.append("\n")
            }
        } else {
            for(i in word.indices) {
                ans[level] = word[i]
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    print(builder.toString())

}