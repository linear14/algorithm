package src.algorithm_beakjoon

// 200525
// 9375 - 패션왕 신해빈

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()

        if(n == 0) println(0)
        else {

            // map에 옷의 분류를 key로 설정한 뒤, 같은 key를 가지고 있는 옷의 이름이 들어갈 경우 value를 +1 해준다.
            val map = mutableMapOf<String, Int>()
            repeat(n) {
                val wear = readLine()!!.split(" ")
                val temp = map[wear[1]] ?: 0
                map[wear[1]] = temp + 1
            }

            // map에 있는 value를 모두 끄집어 list에 담자
            val count = mutableListOf<Int>()
            for (i in map.keys) {
                count.add(map[i]!!)
            }

            // 이전의 모든 경우의 수에서 현재 level의 case만큼 x가지 (곱의 법칙) 더 일어날 수 있음 + 자기 자신의 경우 x가지
            /*
                예를 들어, 2 3 2 가 저장되어 있었다면
                처음 2가지 경우가 있을것이다 (dp[0] = 2)

                dp[1] 을 구하는 과정은 dp[0]에서 발생했던 모든 경우 *3이 되지 않을까?
                추가적으로, 자기 자신만 입을 수 있는 경우 3을 더해줄 수 있다.
                즉, dp[1] = dp[0] * 3 + 3 = (dp[0] + 1) * 3 이다.

                dp[2] 를 구하는 과정 역시, dp[0]과 dp[1]에서 발생했던 모든 경우 *2 에 더해서 자기 자신만 입을 수 있는 경우 + 2 이다.
                즉, dp[2] = (dp[0] + dp[1] + 1) * 2 이다.

                아래 식에서는 sum을 도입하여 조금 더 개선한 식을 보여준다.
                dp[2]를 구하는 과정을 예로들어,
                여기에서 sum은 dp[0] + dp[1] 을 하나로 묶어 처리가 되어있는 상태이다.

                오히려 이 글을 읽고 더 헷갈릴 수도 있으니..
                sum을 도입했던 이유에 대해 다시 생각해봐도 괜찮을듯!
            */
            val dp = Array(count.size) { 0 }
            dp[0] = count[0]
            var sum = dp[0]
            for (i in 1 until count.size) {
                sum += ((dp[i - 1] + 1) * count[i])
                dp[i] = sum
            }

            println(dp[dp.size - 1])
        }
    }
}