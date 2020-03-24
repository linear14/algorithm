package algorithm_example

/*
선택 정렬
- https://youtu.be/8ZiSzteFRYc
- 10개의 숫자 중 가장 작은 값을 찾은 뒤 그 값을 0번 인덱스의 수와 swap
- 남은 9개의 숫자 중 가장 작은 값을 찾은 뒤 그 값을 1번 인덱스의 수와 swap
- 남은 8개의 숫자... 끝까지 반복
- 시간 복잡도 : n^2
 */

fun selection_sort() {
    val array = arrayOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)

    var min: Int? = null
    var index: Int? = null
    var temp: Int? = null

    for(i in 0 until array.size) {
        min = 9999
        for(j in i until array.size) {
            if(min!! > array[j]) {
                min = array[j]
                index = j
            }
        }
        temp = array[i]
        array[i] = array[index!!]
        array[index!!] = temp
    }

    for(i in array) {
        println(i)
    }
}

fun main(args: Array<String>) {
    selection_sort()
}