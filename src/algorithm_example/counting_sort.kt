package algorithm_example

/*
계수 정렬
- https://youtu.be/n4kbFRn2z9M
- 원소들이 값의 범위를 가지고 있을 때 유용하게 사용된다.
- 원소의 크기만큼 그 값의 개수를 세어주는 배열을 만들어 주는 것이 포인트.
- 시간 복잡도 : N (특정 환경에서는 매우 빠름)
- But, 원소의 값에 상당히 의존적. 만약 원소 중 1000000이 있다면? arrayCount의 크기 값을 1000000 으로 만들어줘야함.
 */

fun counting_sort(array: Array<Int>){
    val arrayCount = Array(5) {0}
    for(i in array) {
        arrayCount[i - 1]++
    }
    for(i in arrayCount.indices) {
        for(j in 0 until arrayCount[i]) {
            print("${i + 1}")
        }
    }
}

fun main() {
    val array = arrayOf(
        1, 3, 4, 4, 2, 5, 1, 2, 1, 3,
        4, 1, 1, 2, 5, 3, 4, 3, 1, 3,
        3, 5, 1, 2, 1, 3, 4, 1, 2, 5
    )
    counting_sort(array)
}