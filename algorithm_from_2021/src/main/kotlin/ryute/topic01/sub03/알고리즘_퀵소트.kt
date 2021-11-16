package ryute.topic01.sub03

// 1 10 5 8 7 6 4 3 2 9
// 피벗을 설정한 분할 알고리즘

private fun main() {
    val list = mutableListOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)
    quickSort(list, 0, list.size - 1, 0)

    for(i in list) {
        print("$i ")
    }
}

/*
    피벗 값보다 큰 값을 왼쪽부터 순차적으로 찾는다.
    피벗 값보다 작은 값을 오른쪽부터 순차적으로 찾는다.

    if 큰 값 인덱스 < 작은 값 인덱스 --> swap(큰 값, 작은 값)
    if 큰 값 인덱스 > 작은 값 인덱스 --> swap(작은 값, 피벗 값)
    큰 값 인덱스 = 작은 값 인덱스 일 경우에는? (만들어보고 생각해보자)
 */

private fun quickSort(list: MutableList<Int>, start: Int, end: Int, pivot: Int) {
    if(start >= end) return

    val value = list[pivot]

    var smallerIndex = end
    var largerIndex = start

    while(smallerIndex > 0) {
        if(list[smallerIndex] > value) smallerIndex--
        else return
    }

    while(largerIndex <= end) {
        if(list[largerIndex] < value) largerIndex++
        else return
    }

    if(smallerIndex < largerIndex) {
        swap(list, pivot, smallerIndex)
        quickSort(list, start, smallerIndex - 1, start) // 왼쪽
        quickSort(list, smallerIndex + 1, end, smallerIndex + 1) // 오른쪽...... ㅎㅎ
    } else {
        swap(list, smallerIndex, largerIndex)
        quickSort(list, start, end, pivot)
    }
}

private fun swap(list: MutableList<Int>, indexOne: Int, indexTwo: Int) {
    val temp = list[indexOne]
    list[indexOne] = list[indexTwo]
    list[indexTwo] = temp
}