const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  const dp = [0];

  for(let i = 1; i <= n; i++) {
    const gSqrt = Math.floor(Math.sqrt(i));
    let min = 100000;
    
    for(let j = 1; j <= gSqrt; j++) {
      min = Math.min(min, dp[i - Math.pow(j, 2)] + 1);
    }

    dp[i] = min;
  }

  console.log(dp[n]);
});