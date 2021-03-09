package ryute.topic02.sub04

// 여러수의 최대공약수
private fun main() {
    val n = readLine()!!.toInt()
    val arr = mutableListOf<Int>().apply {
        repeat(n) {
            add(readLine()!!.toInt())
        }
    }
    val diffList = mutableListOf<Int>().apply {
        for(i in 1 until n) {
            add(arr[i] - arr[i - 1])
        }
    }

    var gcd = diffList[0]
    for(diff in diffList) {
        var a = gcd
        var b = diff

        while(a % b != 0) {
            val temp = b
            b = a % b
            a = temp
        }
        gcd = b
    }

    var ans = diffList.size * -1
    for(diff in diffList) {
        ans += diff / gcd
    }

    println(ans)
}
