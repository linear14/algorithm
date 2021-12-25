const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  let ans = 10000000;
  for(let i = 0; i < 3; i++) {
    const dp = Array.from({ length: n }, (_, idx) => [...arr[idx]]);
    for(let j = 0; j < 3; j++) {
      dp[1][j] = i === j ? 2001 : dp[1][j] + dp[0][i];
    }

    for(let j = 2; j < n; j++) {
      dp[j][0] += Math.min(dp[j-1][1], dp[j-1][2]);
      dp[j][1] += Math.min(dp[j-1][0], dp[j-1][2]);
      dp[j][2] += Math.min(dp[j-1][0], dp[j-1][1]);
    }
    
    const candidate = i === 0 ? Math.min(dp[n-1][1], dp[n-1][2])
    : i=== 1 ? Math.min(dp[n-1][0], dp[n-1][2])
    : Math.min(dp[n-1][0], dp[n-1][1]);
    ans = Math.min(ans, candidate);
  }
  return ans;
}