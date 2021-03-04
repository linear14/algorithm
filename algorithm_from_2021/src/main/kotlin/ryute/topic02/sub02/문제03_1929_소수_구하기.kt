package ryute.topic02.sub02

private fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }.apply {
        get(0) to get(1)
    }

    // if문 안돌리는게 좋을듯 (연산 과정이 추가되므로)
    val primeArray = Array(n + 1) {
        if(it == 0 || it == 1) 1 else 0
    }

    for(num in 2..n) {
        var test = num * 2
        while(test <= n) {
            if(primeArray[test] == 0) {
                primeArray[test] = 1
            }
            test += num
        }
    }

    for(i in m..n) {
        if(primeArray[i] == 0) {
            println(i)
        }
    }
}