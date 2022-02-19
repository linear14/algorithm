const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const dp = [1, 1];
rl.on('line', (input) => {
  for(let i = 2; i <= +input; i++) {
    dp.push(dp[i - 1] * i);
  }
  console.log(dp[+input]);
  rl.close();
})