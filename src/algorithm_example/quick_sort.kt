package algorithm_example

/*
퀵 소트
- https://youtu.be/O-O-90zX-U4
- https://youtu.be/gBcUO_6JXIA
- pivot 값(기준 값) 으로 나누어, 좌 우 파트를 다시 sort하는 방법
- 평균적으로 시간복잡도는 N*logN 이지만, 거의 정렬되어 있는 상태에서는 N^2 의 시간복잡도를 가진다.
 */

 /*
 피벗보다 큰 값(그 때의 index -> largerThanPivotIndex) 을 왼쪽에서부터 쭉 찾고,
 피벗보다 작은 값(그 때의 index -> smallerThanPivotIndex)을 오른쪽에서 쭉 찾을 생각.
 largerThanPivotIndex < smallerThanPivotIndex : 두 인덱스가 교차하지 않았다는 의미 -> 각 인덱스에 해당하는 수 끼리 위치 바꿈
 largerThanPivotIndex >= smallerThanPivotIndex : 두 인덱스가 교차 했거나 만났다는 의미 -> 피벗의 값과 smallThanPivotIndex에 해당하는 수 끼리 위치 바꿈
 바뀐 피벗의 위치는 고정. 피벗을 기준으로 왼쪽은 피벗보다 작은 값. 오른쪽은 피벗보다 큰 값.
 */

class Quick {
    fun quickSort(array: Array<Int>, startIndex: Int, endIndex: Int) {
        // 원소가 한 개 일 경우
        if(startIndex >= endIndex) {
            return
        }

        val pivot = startIndex
        var largerThanPivotIndex = startIndex + 1
        var smallerThanPivotIndex = endIndex
        var temp: Int?

        // 엇갈리지 않는 상황 (엇갈릴 때 까지 진행하자는 의미)
        while(largerThanPivotIndex <= smallerThanPivotIndex) {
            // pivot보다 큰 값 찾을 때 까지 돌리기
            while(largerThanPivotIndex <= endIndex && array[largerThanPivotIndex] <= array[pivot]) {
                largerThanPivotIndex++
            }
            // 마찬가지로 작은 값 찾을 때 까지 돌리기 (조건에 들어가면 못 찾았다고 판단한거임)
            while(smallerThanPivotIndex >= startIndex && array[smallerThanPivotIndex] > array[pivot]) {
                smallerThanPivotIndex--
            }

            // 만약, 둘 중 하나만 찾았거나 둘 다 못 찾아서 교차가 되어버렸다? -> pivot 값과 작은 값을 바꿔줌
            if(largerThanPivotIndex > smallerThanPivotIndex) {
                temp = array[pivot]
                array[pivot] = array[smallerThanPivotIndex]
                array[smallerThanPivotIndex] = temp
            }
            // 만약, 교차 하지 않고, 큰 값과 작은 값이 모두 존재했다? -> 둘이 서로 바꿔줌
            else {
                temp = array[largerThanPivotIndex]
                array[largerThanPivotIndex] = array[smallerThanPivotIndex]
                array[smallerThanPivotIndex] = temp
            }
        }

        quickSort(array, startIndex, smallerThanPivotIndex - 1)
        quickSort(array, smallerThanPivotIndex + 1, endIndex)
    }

    fun show(array: Array<Int>) {
        for(i in array.indices) {
            print("${array[i]} ")
        }
    }


}

fun main(args: Array<String>) {
    val quick = Quick()
    val array = arrayOf(26, 5, 37, 1, 61, 11, 37, 15, 48, 19)
    quick.quickSort(array, 0, array.size - 1)
    quick.show(array)
}