const solution = (priorities, location) => {
  const [remainsCount, largerThanMe] = priorities.reduce((pre, cur) => {
    pre[0][cur] += 1;
    for(let i = 0; i <= cur; i++) {
      pre[1][i] += 1;
    }
    return [pre[0], pre[1]];
  }, [Array(10).fill(0), Array(10).fill(0)]);
  
  const mappedPriorites = priorities.map((item, idx) => ({ priority: item, idx }));
  let answer = 1;

  while(true) {
    const next = mappedPriorites.shift();
    if(remainsCount[next.priority] === largerThanMe[next.priority]) {
      if(next.idx === location) {
        return answer;
      }
      else {
        answer += 1;
        remainsCount[next.priority] -= 1;
        for(let i = next.priority; i >= 0; i--) {
          largerThanMe[i] -= 1;
        }
      }
    }
    else {
      mappedPriorites.push(next);
    }
  }
};

// 변수명 정하기 너무 어렵다...ㅎㅎ;;
// 알고리즘에서 변수명은 크게 중요하지 않다고는 함 (그래도 신경 쓰고 싶은데)

const testData = [
  { priorities: [2, 1, 3, 2], location: 2 },
  { priorities: [1, 1, 9, 1, 1, 1], location: 0 },
];

testData.forEach(({ priorities, location }) => {
  console.log(solution(priorities, location));
});
