const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let p;
let dp;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    p = input.split(' ').map(i => +i);
    dp = [...p];
    rl.close();
  }
}).on('close', () => {
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < i; j++) {
      dp[i] = Math.min(dp[i], dp[j] + p[i-j-1]);
    }
  }
  console.log(dp[n-1]);
});