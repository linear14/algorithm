package src.algorithm_beakjoon

// 200524 ~ 200530
// 14501 - 퇴사

/*

        진짜 고민 엄청 많이 했다 ㅠㅠ
        N의 값이 Maximum 15였기 때문에 back_tracking 을 사용하여 문제에 접근했다.

        schedule 2차원 배열에 [0] : 일하는데 걸리는 일수, [1] : 보상비용 을 담고
        available 배열의 크기를 n개로 만들어서, 만약 일을 하기로 결정했다면 1, 일을 하지 않기로 됐다면 0을 대입하는 배열을 만들어준다.
        위 available 배열은 백트래킹용 배열이 된다.
        answers 리스트에는 available에서 만들어진 케이스에서의 보상비용의 합을 모두 저장한다.

        isPossible 함수가 중요하다.
        level과 possible 두개를 매개변수로 받는데, possible은 0이냐 아니면 1이냐를 의미한다.

        level 이전까지의 1이 들어있는 값을 체크하여
        1이 들어있는 경우, 그 때의 일하는데 걸리는 시간을 계속 더해준다.
        이 때, 처음 1이 있는 경우에는, 처음 일을 시작하는 일차를 더해주어야함. (그 뒤로 start flag를 false로 바꿔준다.)
        그 다음부터 1이 있는 경우에는 걸리는 시간을 더해주되,
        이전에 일하고, 그다음 일 할때 까지 바로 일을 하지 않았을(며칠 쉬었을 경우) 경우에 대한 추가 일자를 더해줘야한다. (daySum += (i - temp - schedule[temp][0]))
        이것이 temp가 필요한 이유가 된다.

        possible이 0이면 계속 true로 넘겨주면 되지만
        possible이 1이면 두가지를 고려해줘야한다.
        1) 해당일에 아직 일을 하고 있을 경우. 즉 일이 겹친다. false
        2) 해당일에 만약 일을 한다면 퇴사 전까지 일이 끝나지 않을 경우. false
        이외는 모두 true

 */

fun main() {
    val n = readLine()!!.toInt()
    val schedule = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    val available = Array(n){ 0 }
    val answers = mutableListOf<Int>()

    fun isPossible(level: Int, possible: Int): Boolean {
        var start = true
        var daySum = 0

        var temp = -3
        for(i in 0 until level) {
            if(available[i] == 1) {
                if(start) {
                    start = false
                    daySum = i
                } else {
                    daySum += (i - temp - schedule[temp][0])
                }
                temp = i
                daySum += schedule[i][0]
            }
        }

        if(possible == 1) {
            if (daySum > level) return false
            if (level + schedule[level][0] > n) return false
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == n) {
            var sum = 0
            for(i in available.indices) {
                if(available[i] == 1) sum += schedule[i][1]
            }
            answers.add(sum)
        } else {
            for(i in 0..1) {
                available[level] = i
                if(isPossible(level, i)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)
    print(answers.max())
}

/*
fun main() {
    val n = readLine()!!.toInt()
    val schedule = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    val list = mutableListOf<IntArray>()
    val answers = mutableListOf<Int>()

    fun isNextPossible(day: Int): Boolean {

    }

    fun backTracking(day: Int) {
        if(day >= n) {

        }
        for(i in 0 until n) {
            list.add(schedule[i])
            // 기존 일자
            if(day + schedule[i][0] < n) {
                if(isNextPossible(day)){
                    backTracking(day + schedule[i][0])
                } else {
                    continue
                }
            } else {
                list.removeAt(list.size - 1)
            }
        }
    }
}*/
