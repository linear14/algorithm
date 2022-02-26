const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  const MOD = 10007;
  const dp = [[1,1,1,1,1,1,1,1,1,1]];

  for(let i = 1; i < n; i++) {
    dp.push([1]);
    
    for(let j = 1; j < 10; j++) {
      dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
    }
  }

  console.log(dp[n-1].reduce((pre, cur) => (pre + cur) % MOD, 0));
});