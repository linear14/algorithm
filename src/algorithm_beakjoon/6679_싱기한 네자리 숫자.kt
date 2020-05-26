package src.algorithm_beakjoon

// 200526
// 6679 - 싱기한 네자리 숫자

fun main() {
    fun makeXnaryAndSum(n: Int, x: Int): Int {
        var num = n
        var sum = 0
        while(num >= x) {
            sum += num % x
            num /= x
        }
        sum += num
        return sum
    }

    for(i in 1000..9999) {
        val sum10 = makeXnaryAndSum(i, 10)
        val sum12 = makeXnaryAndSum(i, 12)
        val sum16 = makeXnaryAndSum(i, 16)

        if(sum10 == sum12 && sum12 == sum16) println(i)
    }
}