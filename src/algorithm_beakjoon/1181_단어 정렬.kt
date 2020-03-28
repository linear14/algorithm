package algorithm_beakjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 200328
// 1181 - 단어 정렬

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val array = Array<String>(n) { br.readLine() }

    // sortWith를 사용하여 이중 필터를 걸었음.
    // 1순위. 글자 길이 순 (짧은 것이 먼저 오도록)
    // 2순위. 단어마다 유니코드 값을 비교함
    array.sortWith(Comparator { value1, value2 ->
        if(value1.length == value2.length) {
            var i = 0
            var sort = 0
            while(true) {
                if(value1[i] != value2[i]){
                    sort = value1[i] - value2[i]
                    break
                }
                i++
                if(i == value1.length && i == value2.length) {
                    sort = 0
                    break
                }
            }
            sort
        } else {
            value1.length - value2.length
        }
    })

    // 중복되는 값은 출력에서 제외
    for(i in array.indices) {
        if(i == 0) {
            println(array[0])
            continue
        }
        if(array[i] == array[i - 1]) {
            continue
        }
        bw.write("${array[i]}\n")
    }
    bw.flush()
}

