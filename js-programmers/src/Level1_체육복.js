function solution(n, lost, reserve) {
  const remain = Array.from({ length: n }, () => 1);
  lost.forEach(i => remain[i - 1]--);
  reserve.forEach(i => remain[i - 1]++);
  
  for(let i = 0; i < n; i++) {
    if(remain[i] === 2) {
      if(i !== 0 && remain[i - 1] === 0) { 
        remain[i - 1]++
        continue;
      }
      if(i !== n - 1 && remain[i + 1] === 0) remain[i + 1]++
    }
  }

  return remain.filter(c => c !== 0).length;
}

const testData = [
  { n: 5, lost: [2, 4], reserve: [1, 3, 5] },
  { n: 5, lost: [2, 4], reserve: [3] },
  { n: 3, lost: [3], reserve: [1] },
]

testData.forEach(({ n, lost, reserve }) => {
  console.log(solution(n, lost, reserve));
})