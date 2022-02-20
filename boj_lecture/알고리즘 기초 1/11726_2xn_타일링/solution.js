const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let dp;
rl.on('line', (input) => {
  n = +input;
  dp = Array.from({ length: n + 1 });
  rl.close();
}).on('close', () => {
  dp[0] = 1;
  dp[1] = 1;
  for(let i = 2; i <= n; i++) {
    dp[i] = (dp[i-2] + dp[i-1]) % 10007;
  }
  console.log(dp[n]);
});