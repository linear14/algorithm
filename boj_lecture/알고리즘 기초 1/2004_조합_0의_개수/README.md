# 결과

| 메모리(KB) | 시간(ms) | 비고 |
| :--------: | :------: | :--- |
| 9532 | 208 |      |

# 과정
## 처음 생각했던 방식
### 소인수분해
특정 수에 10을 곱할 때 마다 뒷자리에 0이 추가된다. `10 = 2 x 5`이므로, 2와 5가 한 쌍이 있을 때 마다 0이 붙는다고 생각했고 이전 문제였던 '1676 팩토리얼 0의 개수' 문제도 그런 방식으로 접근했다.

따라서, n! 의 0의 개수를 구하기 위해 1, 2, 3 ... n-2 n-1 n 까지 모두를 소인수분해 해서 2와 5의 개수를 찾은 다음에, 둘 중 가장 작은 값을 정답으로 출력하는 방식을 택했다. (조합 역시 곱으로 이루어진 수들의 소인수를 컨트롤하면 풀 수 있을 것 같았다.)

### 시간 초과
하지만, 문제의 조건에 의하면 최대 20억이라는 숫자가 입력값으로 들어갈 수 있는데, 1 ~ 20억까지의 숫자 모두를 소인수분해 한다면 당연 시간초과가 날 수 밖에 없는 구조였다. 이를 어떻게 해결하면 좋을까 생각을 많이 해봤지만.. 이를 줄일 수 있는 방법을 전혀 생각하지 못해 구글에 도움을 요청했다😂

## 해결 방안
### 소인수의 개수를 구하는 수학적인 방법
내가 작성했던 카운팅 방법은 아래와 같다.

```jsx
// const n = n!에 해당하는 수
let cnt2 = 0;
for(let i = 1; i <= n; i++) {
  let now = i;
  while(now % 2 === 0) {
    cnt2++;
    now /= 2;
  }
}
```
그리고, 솔루션에서 제공한 카운팅 방법은 아래와 같았다.

```jsx
let count = 0;
while(num >= 2) {
  const divided = Math.floor(num / 2);
  count += divided;
  num = divided;
}
```
2의 소인수 개수를 세는 방식이 너무 달랐다.  
나는 `1~원하는 수`까지 하나씩 순회하며, 각 수가 더이상 2로 나누어지지 않을 때 까지 몇 번의 나눗셈 연산이 수행됐는지를 카운팅했다.  
하지만, 아래 방식은 `원하는 수` 하나를 계속해서 2로 나누었고, 나눈 결과를 카운팅 변수에 합했다. 이 방식은 2로 나눈 수가 2보다 작아질 때 까지 계속해서 수행됐다.  
잘 이해가 안가는 방식이었는데, 아래 예시를 통해 쉽게 이해할 수 있었다.

예를 들어, 20이라는 숫자에서 2의 소인수 개수를 얻어야한다고 가정한다.  
그렇다면, 2를 소인수로 가지는 수는 아래와 같다.
```
2, 4, 6, 8, 10, 12, 14, 16, 18, 20
```

하지만, 어떤 수들은 2를 여러개 가질 수 있다. 가령, 2를 2개 가지는 수는 아래와 같다.
```
4, 8, 12, 16, 20
```

2를 3개 가지는 수도 있다.  
```
8, 16
```

2를 4개 가지는 수도 있다.
```
16
```

소인수 2의 개수를 구하는 알고리즘을 떠올려보면, 20을 2로 나누었을 때의 결과인 10을 카운팅 변수에 더한다. 이때는 2를 한개만 가지는 수에 대한 연산 처리다.  
이후, 20을 2로 나누어 동일한 로직을 처리하는데, 이 뜻은 4를 소인수(4는 소인수가 아니지만)로 가지는 숫자에 대한 개수 처리이다. 즉 5개가 더해진다.  
마찬가지로, 8을 소인수로 가지는 수 2개, 16을 소인수로 가지는 수 1개까지 돌리면서 연산하는 방식이다. 

### 약분을 하지 말자
팩토리얼 기본 연산방식으로 손쉽게 계산할 수 있다. `nCr = n! / (n-r)!r!` 이라는 고등학교 시절 배운 공식을 이용하고, 자연스럽게 분모의 n-r과 분자의 n을 약분했다. 그렇게 되면 위의 성질을 이용하기 힘들어진다. 있는 그대로에서 생각해보는 연습이 필요한 것 같다.

## 추가로 알게된 것
### 팩토리얼 연산에서 2와 5의 소인수 개수의 관계
2는 5보다 작은 수이기 때문에, 어떤 팩터리얼 연산의 결과를 소인수분해를 통해 얻은 소인수 5의 개수보다 2의 개수가 많거나 같다.  


# 참고 자료
- https://st-lab.tistory.com/165
- https://www.acmicpc.net/board/view/72777