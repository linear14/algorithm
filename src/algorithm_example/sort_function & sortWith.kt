package algorithm_example

import java.util.*
import java.util.Collections.sort
import kotlin.Comparator

fun main(args: Array<String>) {

    // sort를 사용한 오름차순 정렬
    println("----sort를 사용한 오름차순 정렬----")
    var list1 = listOf(9, 3, 5, 4, 1, 10, 8, 6, 7, 2)
    sort(list1)
    for (i in list1) {
        print("$i ")
    }


    // sort를 사용한 내림차순 정렬
    println("\n----sort를 사용한 내림차순 정렬----")
    var list2 = listOf(9, 3, 5, 4, 1, 10, 8, 6, 7, 2)
    sort(list2, reverseOrder())
    for (i in list2) {
        print("$i ")
    }

    println()
    println()
    // ------------------------------------------------------------
    // ------------------------------------------------------------
    // ------------------------------------------------------------
    // ------------------------------------------------------------

    // 클래스에 데이터를 담는 실무형

    // Student에서 점수가 낮은 순서로 정렬
    println("\n----sortWith를 사용한 오름차순 정렬----")
    val students1 = arrayOf(
        Student("이동현", 89),
        Student("윤진형", 95),
        Student("라현준", 92),
        Student("정문기", 96),
        Student("이보람", 100)
    )
    // 음수면 stu1 < stu2 이므로, 오름차순
    students1.sortWith(Comparator { stu1, stu2 -> stu1.score - stu2.score })
    // students.sortBy{student -> student.score}
    for (i in students1) {
        print("${i.name} ")
    }


    // Student에서 점수가 높은 순서로 정렬
    println("\n----sortWith를 사용한 내림차순 정렬----")
    val students2 = arrayOf(
        Student("이동현", 89),
        Student("윤진형", 95),
        Student("라현준", 92),
        Student("정문기", 96),
        Student("이보람", 100)
    )
    // 음수면 stu1 > stu2 이므로, 내림차순
    students2.sortWith(Comparator { stu1, stu2 -> stu2.score - stu1.score })
    // students.sortBy{student -> student.score}
    for (i in students2) {
        print("${i.name} ")
    }

    println()
    println()
    // ------------------------------------------------------------
    // ------------------------------------------------------------
    // ------------------------------------------------------------
    // ------------------------------------------------------------

    // 코드의 길이를 최소한으로 만드는 알고리즘형
    println("\n----Vector 오름차순 정렬----")
    val vectorTwo = Vector<Pair<String, Int>>()

    vectorTwo.add(Pair("이동현", 89))
    vectorTwo.add(Pair("윤진형", 95))
    vectorTwo.add(Pair("라현준", 92))
    vectorTwo.add(Pair("정문기", 96))
    vectorTwo.add(Pair("이보람", 100))

    vectorTwo.sortWith(Comparator { stu1: Pair<String, Int>, stu2: Pair<String, Int> ->
        stu1.second - stu2.second
    })

    for(i in vectorTwo) {
        print("${i.first} ")
    }
    println()


    // 성적이 같다면, 나이가 적은 사람이 더 좋은 성적
    val vectorThree = Vector<Pair<String, Pair<Int, Int>>>()
    vectorThree.add(Pair("이동현", Pair(89, 26)))
    vectorThree.add(Pair("윤진형", Pair(95, 25)))
    vectorThree.add(Pair("라현준", Pair(92, 25)))
    vectorThree.add(Pair("정문기", Pair(95, 27)))
    vectorThree.add(Pair("이보람", Pair(100, 23)))

    vectorThree.sortWith(Comparator { student1, student2 ->
        if(student1.second.first == student2.second.first) {
            student2.second.second - student1.second.second
        } else {
            student1.second.first - student2.second.first
        }
    })

    for(i in vectorThree) {
        print("${i.first} ")
    }
}

data class Student(val name: String, val score: Int)