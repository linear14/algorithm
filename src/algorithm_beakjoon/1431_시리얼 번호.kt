package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200328
// 1431 - 시리얼 번호

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val serials = Array<String>(n) { br.readLine() }

    serials.sortWith(Comparator { serial1, serial2 ->
        var sort = 0

        if(serial1.length == serial2.length){
            // 조건 2. 자리수의 합
            var sum_serial1 = 0
            var sum_serial2 = 0
            for(i in serial1){
                if(i in '0'..'9') {
                    sum_serial1 += i.toString().toInt()
                }
            }
            for(i in serial2){
                if(i in '0'..'9') {
                    sum_serial2 += i.toString().toInt()
                }
            }
            if(sum_serial1 == sum_serial2) {
                // 조건 3. 사전순 비교
                sort = compareValues(serial1, serial2)
            } else {
                sort = sum_serial1 - sum_serial2
            }
        } else {
            // 조건 1. 길이
            sort = serial1.length - serial2.length
        }
        sort
    })

    for(i in serials) {
        bw.write("$i\n")
    }
    bw.flush()

}

