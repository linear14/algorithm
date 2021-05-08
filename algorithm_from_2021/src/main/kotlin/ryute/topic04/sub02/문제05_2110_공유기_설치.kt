package ryute.topic04.sub02

private fun main() {
    val (n, c) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) { readLine()!!.toInt() }
    arr.sort()

    var start = 1
    var end = arr[n-1] - arr[0]
    var ans = arr[1] - arr[0]

    while(start <= end) {
        var currentPos = arr[0]
        val mid = (start + end) / 2
        var count = 1   // 설치 가능한 공유기의 수

        for(i in 1 until n) {
            val distance = arr[i] - currentPos

            if(distance >= mid) {
                currentPos = arr[i]
                count++
            }
        }

        // CASE 1. Count >= c 에서 ans값 갱신
        if(count >= c) {
            start = mid + 1
            ans = mid
        } else if(count < c) {
            end = mid - 1
        }

        // CASE 2. Count == c 에서 ans값 갱신
        /*if(count >= c) {
            start = mid + 1
        } else if(count < c) {
            end = mid - 1
        }

        if(count == c) {
            ans = mid
        }*/
    }

    println(ans)
}