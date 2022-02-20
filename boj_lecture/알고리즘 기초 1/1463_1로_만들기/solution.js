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
  dp[0] = 0;
  dp[1] = 0;

  for(let i = 2; i <= n; i++) {
    const c1 = dp[i-1];
    const c2 = i % 2 === 0 ? dp[i/2] : 10000000;
    const c3 = i % 3 === 0 ? dp[i/3] : 10000000;

    dp[i] = Math.min(c1, c2, c3) + 1;
  }

  console.log(dp[n]);
});