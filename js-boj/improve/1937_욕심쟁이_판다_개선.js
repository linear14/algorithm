// https://www.acmicpc.net/source/35988855
// dqdq4197님의 풀이를 보고 학습했습니다.

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
const arr = [];
const dp = [];
let ans = 0;
const d = [[1, 0], [-1, 0], [0, 1], [0, -1]];

rl.on('line', (input) => {
  if(!n) {
    n = Number(input);
    for(let i = 0; i < n; i++) {
      dp.push(Array(n).fill(null));
    }
  }
  else {
    arr.push(input.split(' ').map(i => Number(i)));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      ans = Math.max(ans, dfs(i, j));
    }
  }
  return ans;
}

const dfs = (cy, cx) => {
  if(!dp[cy][cx]) {
    dp[cy][cx] = 1;
    let curMax = 0;

    for(let i = 0; i <= 3; i++) {
      const [ny, nx] = [cy + d[i][0], cx + d[i][1]];

      if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if(arr[cy][cx] < arr[ny][nx]) {
          curMax = Math.max(curMax, dfs(ny, nx));
        }
      }
    }
    dp[cy][cx] += curMax;
  }
  return dp[cy][cx];
}