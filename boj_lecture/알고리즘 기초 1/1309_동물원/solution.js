const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  const MOD = 9901;
  const dp = Array.from({ length: n }, () => Array(2));
  dp[0] = [1, 2];

  for(let i = 1; i < n; i++) {
    dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
    dp[i][1] = ((dp[i-1][0] * 2) % MOD + dp[i-1][1]) % MOD;
  }

  console.log((dp[n-1][0] + dp[n-1][1]) % MOD);
});