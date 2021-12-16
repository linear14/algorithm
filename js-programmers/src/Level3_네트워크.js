const solution = (n, computers) => {
  let ans = 0;
  const isVisited = Array(n).fill(false);

  for(let i = 0; i < n; i++) {
    if(!isVisited[i]) {
      ans++;

      isVisited[i] = true;
      const q = [i];
      while(q.length > 0) {
        const now = q.shift();
        for(let j = 0; j < n; j++) {
          if(!isVisited[j] && computers[now][j] === 1) {
            isVisited[j] = true;
            q.push(j);
          }
        }
      }
    }
  }

  return ans;
}



const testcase = [
  { 'n': 3, 'computers': [[1, 1, 0], [1, 1, 0], [0, 0, 1]] },
  { 'n': 3, 'computers': [[1, 1, 0], [1, 1, 1], [0, 1, 1]] },
];

testcase.forEach(({ n, computers }) => {
  console.log(solution(n, computers));
})