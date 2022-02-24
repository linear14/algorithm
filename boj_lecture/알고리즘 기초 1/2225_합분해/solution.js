const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const MOD = 1_000_000_000;

let n;
let k;
rl.on('line', (input) => {
  [n, k] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(1));

  for(let i = 1; i <= n; i++) {
    for(let j = 2; j <= k; j++) {
      dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
    }
  }
  
  console.log(dp[n][k]);
});