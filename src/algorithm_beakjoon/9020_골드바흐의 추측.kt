package algorithm_beakjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 200404
// 9020 - 골드바흐의 추측

/*
        8 -> 2 3 5 7
        10 -> 2 3 5 7

        0번 인덱스 고정. 0번 인덱스부터 하나씩 더해봄. 만약 n을 넘었다? -> continue(다음 인덱스로)
        만약 n값을 얻었다 ? -> 리스트에 값을 넣는다.

        그리고 만약 인덱스가 num/2보다 큰 경우? -> 그냥 num에대한 조사를 끝냄
 */

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var t = readLine()!!.toInt()

    while(t-- > 0) {
        val n = readLine()!!.toInt()

        val numberList = Array(n + 1){ 0 }
        numberList[1] = 1
        val sosus = mutableListOf<Int>()

        for(i in 2..n) {
            if(numberList[i] != 0) continue
            for(j in i + i..n step i) numberList[j]++
        }

        for(i in numberList.indices) {
            if(numberList[i] == 0) sosus.add(i)
        }

        var possibles = mutableListOf<Int>()
        a@ for((index, sosu) in sosus.withIndex()) {
            if(sosu > n / 2) break
            for(loop in index until sosus.size) {
                if(sosu + sosus[loop] > n) continue@a
                if(sosu + sosus[loop] == n) {
                    possibles.add(sosu)
                }
            }
        }
        if(possibles.size != 0) {
            bw.write("${possibles[possibles.size - 1]} ${n - possibles[possibles.size - 1]}\n")
        } else {
            bw.write("${possibles[0]} ${n - possibles[0]}\n")
        }
    }
    bw.flush()
}


/*
어느 고수님의 풀이.. (180ms)
어차피 어떤 짝수를 두 수의 합으로 만들기 위해서는 각 수가 대칭성을 띄어야함
예를들어, 8같은 경우는 4+4 3+5 2+6 의 꼴로만 그 수를 표현할 수 있음.
그러니, 애초에 8을 2로 나눈 값 두개를 a,b의 변수로 설정하고
a--, b++을 통해 소수리스트에서의 인덱스를 하나씩 변경해가며 둘 다 소수일 경우 write 해주는 방식을 취하셨다...
보고 배우자^^

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val testCase = br.readLine().toInt()

    val arr = BooleanArray(10001) //짝수의 최댓값이 1만이니깐. 1만의 소수갯수는 1229
    for ( i in arr.indices ) arr[i] = true
    arr[0] = false
    arr[1] = false

    var i = 2
    while ( i * i <= 10000 ) {
        var j = i * i
        while ( j <= 10000 ) {
                arr[j] = false
            j += i
        }
    i++
    }

    var w1 = 1
    var a: Int
    var b: Int
    while ( w1 <= testCase ) {
        val getNumber = br.readLine().toInt()
        a = getNumber / 2
        b = getNumber / 2

        while (true) {
            if (arr[a] && arr[b]) {
                bw.write("$a $b\n")
                bw.flush()
                break
            }
            a--
            b++
        }
    w1++
    }
    bw.close()
}

 */