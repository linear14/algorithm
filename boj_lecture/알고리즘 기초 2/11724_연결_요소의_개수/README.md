# 결과

| 메모리(KB) | 시간(ms) | 비고 |
| :--------: | :------: | :--- |
| 105280 | 1072 |      |
| 105908 | 1120 | 큐 직접 구현 |

# 과정

## 큐를 직접 구현했는데 왜 더 느리지?

unshift이 시간을 많이 잡아먹는 것으로 안다. O(N)의 시간 복잡도.. 그래서 직접 큐를 만들어서 push / pop 연산의 수행 시간을 O(1)로 만들었는데, 오히려 태스크를 해결하는데 걸리는 시간이 늘어났다?!

아마 큐안에 들어가는 원소의 수가 적어서.. unshift의 연산 속도보다 내부적으로 구현한 큐의 push 속도가 더 느릴 수 있다고 생각해야겠다. 다른 문제를 풀면서 다시 검증 후 고민해보는걸로!
