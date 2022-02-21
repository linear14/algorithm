const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const dp = [[0, 1, 1, 1, 1, 1, 1, 1, 1, 1], [1, 1, 2, 2, 2, 2, 2, 2, 2, 1]];
const DIVISOR = 1_000_000_000;

rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  for(let i = 2; i < n; i++) {
    dp[i] = Array(10).fill(0);

    dp[i][0] = dp[i-1][1];
    dp[i][9] = dp[i-1][8];
    
    for(let j = 1; j < 9; j++) {
      dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIVISOR;
    }
  }
  console.log(sum(dp[n-1]));
});

const sum = (arr) => {
  return arr.reduce((pre, cur) => (pre + cur) % DIVISOR, 0);
}